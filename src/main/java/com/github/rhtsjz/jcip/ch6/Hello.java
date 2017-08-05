package com.github.rhtsjz.jcip.ch6;

import java.util.concurrent.*;

/**
 * Created by smile on 2017/7/23.
 */
public class Hello {
    Executor executor = Executors.newSingleThreadExecutor();
    Object o;
    Callable<Hello> callable;

    Future f;
    ExecutorService executorService;
    FutureTask futureTask;



}
