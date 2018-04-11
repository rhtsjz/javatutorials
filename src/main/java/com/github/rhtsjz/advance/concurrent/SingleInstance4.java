package com.github.rhtsjz.advance.concurrent;

public class SingleInstance4 {
    private static volatile String[] values;//不管是否加volatile关键字都不会出现不安全发布现象

    private static volatile String value;

    public static String[] getInstance() throws InterruptedException {
        if (null == values) {
            synchronized (SingleInstance4.class) {
                if (null == values) {
                    int num = 1000;
                    values = new String[num];//不安全发布
                    for (int i = 0; i < num; i++) {
                        values[i] = i + Thread.currentThread().getName();
                    }
                }
            }
        }
        return values;
    }

    public static String getInstance1() throws InterruptedException {
        if (value == null) {
            synchronized (SingleInstance4.class) {
                if (null == value) {
                    value = "hello";
                }
            }
        }
        return value;
    }
}
