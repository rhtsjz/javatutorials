package com.github.rhtsjz;

public class LongEqualsExample {

    public static void main(String[] args) {
        Long l1 = 500L;
        Long l2 = 500L;
        System.out.println(l1 == l2);

        Long l3 = new Long(1);
        Long l4 = new Long(1);
        System.out.println(l3 == l4);

        long ll1 = l1;
        long ll2 = l2;
        System.out.println(ll1 == ll2);

        long ll3 = l3;
        long ll4 = l4;
        System.out.println(ll3 == l3);

        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println(i1 == i2);
        Integer i3 = 50;

        System.out.println(Integer.valueOf(1).equals(1L));

        System.out.println(Math.multiplyExact(Long.MAX_VALUE, Long.MAX_VALUE));

    }
}
