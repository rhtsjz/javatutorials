package com.github.rhtsjz.advance.concurrent;

public class SafeLazyInstanceWayStaticInnerClassHolder {

    private static class InstanceHolder {
        public static SafeLazyInstanceWayStaticInnerClassHolder instance = new SafeLazyInstanceWayStaticInnerClassHolder();
    }

    public static SafeLazyInstanceWayStaticInnerClassHolder getInstance() {
        return InstanceHolder.instance;
    }
}
