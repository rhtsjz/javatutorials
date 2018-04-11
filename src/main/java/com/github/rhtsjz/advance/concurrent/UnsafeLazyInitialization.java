package com.github.rhtsjz.advance.concurrent;

public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    private UnsafeLazyInitialization() {

    }

    public synchronized static UnsafeLazyInitialization getInstance() {
        if (instance == null) {
            instance = new UnsafeLazyInitialization();
        }
        return instance;
    }

    public static void main(String[] args) {

        UnsafeLazyInitialization u = UnsafeLazyInitialization.getInstance();
    }
}
