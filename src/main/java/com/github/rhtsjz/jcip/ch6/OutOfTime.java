package com.github.rhtsjz.jcip.ch6;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by smile on 2017/3/11.
 */
public class OutOfTime {

    public static void main(String[] args) throws InterruptedException {
        // 实际情况是程序运行1秒就结束了，并抛出一个异常消息"Timer already cancelled"
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);

    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
