package com.github.rhtsjz.advance.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class CMapMain {
    public static void main(String[] args) {

        ConcurrentHashMap c = new ConcurrentHashMap();
        for (int i = 0; i < 2 << 10; i += 16) {
            c.put(i, 1);
        }

        System.out.println(c.size());
    }
}
