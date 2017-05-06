package com.github.rhtsjz.jvm.ch7;

/**
 * Created by smile on 2017/4/23.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println(SubClass.class.getSimpleName()+"init!");
    }
}
