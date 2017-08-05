package com.github.rhtsjz.jcip.ch6;

import java.util.TimerTask;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by smile on 2017/3/11.
 */
public class OutOfTime1 {
    private static final ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);
//    private static final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(10);

    public static void main(String[] args) throws InterruptedException {
        // 实际情况是程序运行1秒就结束了，并抛出一个异常消息"Timer already cancelled"

        exec.schedule(new ThrowTask(), 1, TimeUnit.SECONDS);

        SECONDS.sleep(1);
        exec.schedule(new ThrowTask(), 5, TimeUnit.SECONDS);
        SECONDS.sleep(5);
        exec.shutdown();

    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        }
    }
}
