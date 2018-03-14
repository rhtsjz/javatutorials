package com.github.rhtsjz.advance.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(1, 1);
        m.put(17, 2);
        m.put(33, 3);
        m.put(49, 4);
        m.put(65, 5);
        m.put(81, 6);
        m.put(97, 7);
        m.put(113, 8);
        m.put(129, 11);
        m.put(161, 12);
        m.put(193, 13);
        m.put(225, 14);
        m.put(257, 15);
        m.put(321, 21);
        m.put(385, 22);
        m.put(449, 23);
//        m.put(513, 24);
//        m.put(577, 25);
        m.get(449);
        for (Object es : m.entrySet()) {
            System.out.println(((Map.Entry) es).getKey());
        }

        Map lm = new LinkedHashMap();
        lm.put("a", 1);
        lm.put("b", 2);
        lm.put("c", 3);
        lm.put("b", 4);
        for (Object k : lm.keySet()) {
            System.out.println(k);
        }

        Map tm = new TreeMap();
        tm.put("a", 1);
        tm.put("b", 2);
        tm.put("c", 3);
        tm.put("b", 4);
        for (Object k : tm.keySet()) {
            System.out.println(k);
        }
    }
}
