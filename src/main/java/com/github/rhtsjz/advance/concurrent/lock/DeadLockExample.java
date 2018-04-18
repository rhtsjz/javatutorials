package com.github.rhtsjz.advance.concurrent.lock;

public class DeadLockExample {

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend ming = new Friend("ming");
        final Friend hong = new Friend("hong");
        new Thread(new Runnable() {
            @Override
            public void run() {
                ming.bow(hong);
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                hong.bow(ming);
            }
        }).start();
    }

}
