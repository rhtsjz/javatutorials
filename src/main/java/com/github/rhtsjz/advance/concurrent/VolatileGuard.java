package com.github.rhtsjz.advance.concurrent;

import java.util.HashMap;
import java.util.Map;

public class VolatileGuard {
    Map configOptions;
    char[] configText;
    volatile boolean initialized = false;

    public static void main(String[] args) {
        VolatileGuard vg = new VolatileGuard();
        vg.init();
        vg.check();

    }

    private void init() {
        new Thread() {
            @Override
            public void run() {
                configOptions = new HashMap();
                configText = new char[]{'a', 'b', 'c'};
                initialized = true;
            }
        }.start();
    }

    private void check() {
        new Thread() {
            @Override
            public void run() {
                while (!initialized) {
                    try {
                        System.out.println("sleep");
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(configText);
            }
        }.start();

    }

}
