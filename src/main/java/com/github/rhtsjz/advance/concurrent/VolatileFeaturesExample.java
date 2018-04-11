package com.github.rhtsjz.advance.concurrent;

public class VolatileFeaturesExample {

    volatile long vl = 0L;

    public void getAndIncrement() {
        vl++;
    }

    public long getVl() {
        return vl;
    }

    public void setVl(long vl) {
        this.vl = vl;
    }
}
