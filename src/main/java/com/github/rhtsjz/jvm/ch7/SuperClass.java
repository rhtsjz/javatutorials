package com.github.rhtsjz.jvm.ch7;

/**
 * Created by smile on 2017/4/23.
 */
public class SuperClass {
    static {
        System.out.println(SuperClass.class.getSimpleName() + "init!");
    }

    public static int value = 123;
}
