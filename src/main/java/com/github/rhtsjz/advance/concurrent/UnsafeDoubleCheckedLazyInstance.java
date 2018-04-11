package com.github.rhtsjz.advance.concurrent;

public class UnsafeDoubleCheckedLazyInstance {

    private static UnsafeDoubleCheckedLazyInstance instance;

    private UnsafeDoubleCheckedLazyInstance() {
    }

    public static UnsafeDoubleCheckedLazyInstance getInstance() {
        if (instance == null) {
            synchronized (UnsafeDoubleCheckedLazyInstance.class) {
                if (instance == null) {
                    instance = new UnsafeDoubleCheckedLazyInstance();
                }
            }
        }
        return instance;
    }
}
