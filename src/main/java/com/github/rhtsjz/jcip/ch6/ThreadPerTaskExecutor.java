package com.github.rhtsjz.jcip.ch6;

import java.util.concurrent.Executor;

/**
 * Created by smile on 2017/3/9.
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
