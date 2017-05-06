package com.github.rhtsjz.jvm.ch7;

/**
 * Created by smile on 2017/4/23.
 */
public class ConstClass {
    static {
        System.out.println(ConstClass.class.getSimpleName() + "init!");
    }

    public static final String HELLO_WORLD = "hello world";
}
