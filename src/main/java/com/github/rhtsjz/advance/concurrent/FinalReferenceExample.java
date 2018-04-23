package com.github.rhtsjz.advance.concurrent;

public class FinalReferenceExample {

    final int[] intArray;
    static FinalReferenceExample obj;

    public FinalReferenceExample() {
        this.intArray = new int[1];
        intArray[0] = 1;
    }

    public static void writerOne() {
        obj = new FinalReferenceExample();
    }

    public static void writerTwo() {
        obj.intArray[0] = 2;
    }

    public static void reader() {
        if (obj != null) {
            int tmp1 = obj.intArray[0];
            System.out.println(tmp1);
        }
    }
}
