package com.github.rhtsjz.advance.concurrent;

public class SafeInstanceWayVolatile {

    private volatile static SafeInstanceWayVolatile instance;

    private SafeInstanceWayVolatile() {
    }

    public static SafeInstanceWayVolatile getInstance() {
        if (instance == null) {
            synchronized (SafeInstanceWayVolatile.class) {
                if (instance == null) {
                    instance = new SafeInstanceWayVolatile();
                }
            }
        }
        return instance;
    }
}
