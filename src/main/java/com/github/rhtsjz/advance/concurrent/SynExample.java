package com.github.rhtsjz.advance.concurrent;

public class SynExample {

    public static void main(String[] args) {
        SynExample se = new SynExample();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                se.reader();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                se.writer();
            }
        };
        t1.start();
        t2.start();
    }

    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println(a);
        }
    }
}
