package com.github.rhtsjz.advance.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class SynMain {

    public static void main(String[] args) {
        SynMain syn = new SynMain();
        Thread t1 = new Thread(syn::synSayHello);
        Thread t2 = new Thread(syn::synSayHello);
        CyclicBarrier cb = new CyclicBarrier(3);

    }


    private synchronized void synSayHello() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello" + Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis());
    }
}
