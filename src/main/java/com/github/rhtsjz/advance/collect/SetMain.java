package com.github.rhtsjz.advance.collect;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {
        Set s;
        s = new HashSet<>();
        s = new LinkedHashSet();
        s = new TreeSet();
        s.add(97);
        for (int i = 1; i < 64; i++) {
            s.add(i);
        }
        s.add(97);
        s.add(1);
        s.add(17);
        s.add(33);
        s.add(49);
        s.add(65);
        s.add(81);
        s.add(97);
        s.add(113);
        s.add(129);
        s.add(161);
        s.add(193);
        s.add(225);
        s.add(257);
        s.add(321);
        s.add(385);
        s.add(449);
        System.out.println(s.size());
    }
}
