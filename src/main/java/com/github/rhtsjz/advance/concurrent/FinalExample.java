package com.github.rhtsjz.advance.concurrent;

public class FinalExample {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                FinalExample.writer();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                FinalExample.reader();
            }
        }.start();

    }

    private int i;
    private final int j;
    private static FinalExample obj;

    private FinalExample() {
        i = 1;
        j = 2;
    }

    public static void writer() {
        obj = new FinalExample();
    }

    public static void reader() {
        FinalExample o = obj;
        int a = o.i;
        int b = o.j;
        System.out.println(a);
        System.out.println(b);
    }
}
