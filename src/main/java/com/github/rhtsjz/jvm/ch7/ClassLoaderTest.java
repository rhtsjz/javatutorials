package com.github.rhtsjz.jvm.ch7;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by smile on 2017/5/6.
 */
public class ClassLoaderTest {

    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            /**
             * Loads the class with the specified <a href="#name">binary name</a>.
             * This method searches for classes in the same manner as the {@link
             * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
             * machine to resolve class references.  Invoking this method is equivalent
             * to invoking {@link #loadClass(String, boolean) <tt>loadClass(name,
             * false)</tt>}.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class was not found
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){
                    throw new ClassCastException(name);
                }
            }
        };

        Object object = classLoader.loadClass("com.github.rhtsjz.jvm.ch7.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());

        System.out.println(object instanceof ClassLoaderTest);

    }
}
