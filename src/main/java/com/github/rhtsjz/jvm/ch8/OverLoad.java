package com.github.rhtsjz.jvm.ch8;

import java.io.Serializable;

/**
 * Created by smile on 2017/5/17.
 */
public class OverLoad {

//    public static void sayHello(Object arg) {
//        System.out.println("Hello Object");
//    }

//    public static void sayHello(int arg) {
//        System.out.println("Hello int");
//    }

//    public static void sayHello(long arg) {
//        System.out.println("Hello long");
//    }

//    public static void sayHello(Character arg) {
//        System.out.println("Hello Character");
//    }
//
//    public static void sayHello(char arg) {
//        System.out.println("Hello char");
//    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char...");
    }

//    public static void sayHello(Serializable arg) {
//        System.out.println("Hello Serializable");
//    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
