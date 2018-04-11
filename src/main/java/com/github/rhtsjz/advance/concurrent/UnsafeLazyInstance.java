package com.github.rhtsjz.advance.concurrent;

public class UnsafeLazyInstance {
    private static UnsafeLazyInstance instance;

    private UnsafeLazyInstance() {

    }

    public synchronized static UnsafeLazyInstance getInstance() {
        if (instance == null) {
            instance = new UnsafeLazyInstance();
        }
        return instance;
    }

    public static void main(String[] args) {

        UnsafeLazyInstance u = UnsafeLazyInstance.getInstance();
    }
}
