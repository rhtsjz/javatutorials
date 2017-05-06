package com.github.rhtsjz.jvm.ch9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by smile on 2017/4/9.
 */
public class DynamicProxyTest {
    interface IHello {
        void sayHello(String name);
    }

    static class Hello implements IHello {
        @Override
        public void sayHello(String name) {
            System.out.println("hello world! " + name);
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                    originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome.");
            return method.invoke(originalObj, args);
        }

    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello("Lin");
    }
}
