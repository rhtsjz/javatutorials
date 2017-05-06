package com.github.rhtsjz.jcip.ch7;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by smile on 2017/3/13.
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    public static void main(String[] args) {
        try {
            List<BigInteger> primes = aSecondOfPrimes();
            int current = 0;
            for (BigInteger prime : primes) {
                System.out.printf("%d\t", prime);
                if (++current % 10 == 0) {
                    System.out.println();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
