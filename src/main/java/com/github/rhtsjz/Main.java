package com.github.rhtsjz;

public class Main {

    public static void main(String[] args) {
        // write your code here
        sort(1, 2);
        sort(0, 0);
        sort(2, 1);
    }

    public static void sort(int low, int high) {
        assert (low > 0 && high > 0 && low <= high);
        System.out.println("low: " + low);
        System.out.println("high: " + high);
    }
}
