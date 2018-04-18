package com.github.rhtsjz.advance.collect;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue q = new PriorityQueue();
        for (int i = 0; i < 100; i++) {
            Integer ii = new Integer(i);
            q.add(new Object());
        }
        while (q.peek() != null) {
            System.out.println(q.poll());
        }



    }
}
