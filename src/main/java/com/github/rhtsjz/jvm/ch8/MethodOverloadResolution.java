package com.github.rhtsjz.jvm.ch8;

/**
 * Created by smile on 2017/5/17.
 */
public class MethodOverloadResolution {

    abstract static class Human{

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human guy){
        System.out.println("hello, guy!");
    }

    public void sayHello(Man guy){
        System.out.println("Hello, gentlemen!");
    }

    public void sayHello(Woman guy){
        System.out.println("Hello, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        MethodOverloadResolution mor = new MethodOverloadResolution();
        mor.sayHello(man);
        mor.sayHello(woman);
    }
}
