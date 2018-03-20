package com.github.rhtsjz.advance.collect;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class CollectionMain {
    public static void main(String[] args) {
        Map m = new HashMap<>();
        System.out.println(m.size());

        Set s = new HashSet<>();
        System.out.println(s.size());
        SortedSet ss = new TreeSet();
        System.out.println(ss.size());
        NavigableSet ns = new TreeSet();
        System.out.println(ns.size());
        BlockingQueue bq = new ArrayBlockingQueue(1);
        TransferQueue tq = new LinkedTransferQueue();
        Deque dq = new ArrayDeque();
        BlockingDeque bdq = new LinkedBlockingDeque();


        Queue q = new ArrayDeque();
    }


}
