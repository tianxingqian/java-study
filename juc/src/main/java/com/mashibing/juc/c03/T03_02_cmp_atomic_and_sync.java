package com.mashibing.juc.c03;


import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/*
    比较 Atomxxx 与 synchronized 高效

 */
public class T03_02_cmp_atomic_and_sync {

    static AtomicLong count = new AtomicLong(0);
    static long countSync = 0L;
    static LongAdder longAdder = new LongAdder();

    final static long cnt = 10000;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10000];

        //  AtomicLong
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < cnt; k++) {
                    count.incrementAndGet();
                }
            });
        }
        long start = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        long end = System.currentTimeMillis();
        System.out.println("Atomic: " + count.get() + " time:" + (end - start));

        // sychronized
        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < cnt; k++) {
                    synchronized (lock) {
                        countSync++;
                    }
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        end = System.currentTimeMillis();
        System.out.println("Synchronized: " + countSync + " time:" + (end - start));

        // ---------------  LongAdder
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < cnt; k++) {
                    longAdder.increment();
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        end = System.currentTimeMillis();
        System.out.println("LongAdder: " + longAdder.longValue() + " time:" + (end - start));

    }

}
