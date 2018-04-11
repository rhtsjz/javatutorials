package com.github.rhtsjz.advance.concurrent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CMapMain {
    public static void main(String[] args) {

        ConcurrentHashMap c = new ConcurrentHashMap();
        for (int i = 0; i < 2 << 10; i += 16) {
            c.put(i, 1);
        }

        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            System.out.println(Thread.currentThread().getName());
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
