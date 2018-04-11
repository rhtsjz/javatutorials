package com.github.rhtsjz.advance.concurrent;

public class TopThreadMain {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (System.currentTimeMillis() % 1000 == 1)
                        System.out.println(Thread.currentThread().getName());
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());

                }
            }
        }.start();
    }
}
