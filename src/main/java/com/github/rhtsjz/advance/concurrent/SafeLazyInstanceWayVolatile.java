package com.github.rhtsjz.advance.concurrent;

public class SafeLazyInstanceWayVolatile {

    private volatile static SafeLazyInstanceWayVolatile instance;

    private SafeLazyInstanceWayVolatile() {
    }

    public static SafeLazyInstanceWayVolatile getInstance() {
        if (instance == null) {
            synchronized (SafeLazyInstanceWayVolatile.class) {
                if (instance == null) {
                    instance = new SafeLazyInstanceWayVolatile();
                }
            }
        }
        return instance;
    }
}
