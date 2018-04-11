package com.github.rhtsjz.advance.concurrent;

public class SafeInstanceWayStaticInnerClassHolder {

    private static class InstanceHolder {
        public static SafeInstanceWayStaticInnerClassHolder instance = new SafeInstanceWayStaticInnerClassHolder();
    }

    public static SafeInstanceWayStaticInnerClassHolder getInstance() {
        return InstanceHolder.instance;
    }
}
