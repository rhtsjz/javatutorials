package com.github.rhtsjz.jvm.ch3;

/**
 * Created by smile on 2017/4/4.
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设在这行发生GC，objA和objB是否被回收？
        System.gc();
    }

    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }

}
