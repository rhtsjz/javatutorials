package com.github.rhtsjz.advance.concurrent;

public class UnsafeDoubleCheckedInstance {

    private static UnsafeDoubleCheckedInstance instance;

    private UnsafeDoubleCheckedInstance() {
    }

    public static UnsafeDoubleCheckedInstance getInstance() {
        if (instance == null) {
            synchronized (UnsafeDoubleCheckedInstance.class) {
                if (instance == null) {
                    instance = new UnsafeDoubleCheckedInstance();
                }
            }
        }
        return instance;
    }
}
