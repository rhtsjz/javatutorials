package com.github.rhtsjz.advance.collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {
        List l;
        l = new ArrayList();
        l = new LinkedList();
        Object o = l.remove("3");
        System.out.println(o);
        l.add(97);
        for (int i = 1; i < 64; i++) {
            l.add(i);
        }
        l.add(97);
        l.add(1);
        l.add(17);
        l.add(33);
        l.add(49);
        l.add(65);
        l.add(81);
        l.add(97);
        l.add(113);
        l.add(129);
        l.add(161);
        l.add(193);
        l.add(225);
        l.add(257);
        l.add(321);
        l.add(385);
        l.add(449);
        System.out.println(l.size());
    }
}
