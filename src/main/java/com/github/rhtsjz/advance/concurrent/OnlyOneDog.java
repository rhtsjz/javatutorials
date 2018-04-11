package com.github.rhtsjz.advance.concurrent;

public class OnlyOneDog {

    private static class InstanceHolder {
        public static OnlyOneDog instance = new OnlyOneDog();
    }

    public static OnlyOneDog getInstance() {
        return InstanceHolder.instance;
    }
}
