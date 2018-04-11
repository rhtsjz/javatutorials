package com.github.rhtsjz.advance.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsafeInstance1Tester {
    static Runnable createRunnable() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                String[] va;
                String v;
                try {
                    va = UnsafeInstance1.getInstance();
                    print(va);
//                    v = UnsafeInstance1.getInstance1();
//                    System.out.println(v+"------------------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return run;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Runnable r1 = createRunnable();
        Runnable r2 = createRunnable();
        Runnable r3 = createRunnable();
        es.submit(r1);
        es.submit(r2);
        es.submit(r3);

        es.shutdown();
    }

    static void print(String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (null == v[i]) {
                System.out.println(v[i]);
            }
        }
        System.out.println("At thread name is " + Thread.currentThread().getName() + " null. ");
    }
}
