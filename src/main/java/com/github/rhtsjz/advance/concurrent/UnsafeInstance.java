package com.github.rhtsjz.advance.concurrent;

public class UnsafeInstance {
    private static UnsafeInstance instance;

    private UnsafeInstance() {

    }

    public synchronized static UnsafeInstance getInstance() {
        if (instance == null) {
            instance = new UnsafeInstance();
        }
        return instance;
    }

    public static void main(String[] args) {

        UnsafeInstance u = UnsafeInstance.getInstance();
    }
}
