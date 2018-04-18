package com.github.rhtsjz.advance.concurrent.lock;

public class NoLockDeadLockExample implements Runnable {
    static {
        System.out.println("Getting read to greet the world");

        Thread t = new Thread(new NoLockDeadLockExample());
        t.setName("T------------------------------------1");
        t.start();
        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("wont't see me");
        }
    }


    @Override
    public void run() {
        Thread t = new Thread(new NoLockDeadLockExample());
        t.setName("T--------------------------1 too");
        t.start();
        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("won't see me too");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
