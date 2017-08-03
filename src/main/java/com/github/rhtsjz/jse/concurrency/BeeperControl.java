package com.github.rhtsjz.jse.concurrency;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by zsj on 17-3-13.
 */
public class BeeperControl {
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(0);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            public void run() {
                System.out.println("beep" + Calendar.getInstance().getTime());
            }
        };

        final ScheduledFuture<?> beeperHandle
                = scheduledExecutorService.scheduleAtFixedRate(beeper, 1, 10, SECONDS);

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                beeperHandle.cancel(true);
//                scheduledExecutorService.shutdown();
            }
        }, 25, SECONDS);
    }

    public static void main(String[] args) {
        BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();
    }
}
