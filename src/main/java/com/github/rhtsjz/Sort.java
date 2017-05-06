package com.github.rhtsjz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by smile on 2017/2/19.
 */
public class Sort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        Collections.sort(list);
        System.out.println(list);

    }
}
