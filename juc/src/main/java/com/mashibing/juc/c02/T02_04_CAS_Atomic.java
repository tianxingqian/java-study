package com.mashibing.juc.c02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 *
 */
public class T02_04_CAS_Atomic {

    AtomicLong countAtomic = new AtomicLong(0);
    volatile int countSyn = 0;
    final Object lock = new Object();

    void atomic() {
        for (int i = 0; i < 10000; i++) {
            countAtomic.incrementAndGet();
        }
    }

    void sync() {
//        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
            synchronized (lock) {
                countSyn++;
            }
            }
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        T02_04_CAS_Atomic t = new T02_04_CAS_Atomic();

        int threadSize = 1000;

        // atomic
        List<Thread> threads = new ArrayList<>();

        for (int i =0; i< threadSize; i++) {
            threads.add(new Thread(t::atomic, "atomic"));
        }
        long start = System.currentTimeMillis();
//        for(Thread t1 : threads) t1.start();
//        for(Thread t1 : threads) t1.join();

//        threads.forEach(o->o.start());
//        threads.forEach(o-> {
//            try {
//                o.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        long end = System.currentTimeMillis();

        // synchronized
        List<Thread> threadsSync = new ArrayList<>();

        for (int i =0; i<threadSize; i++) {
            threadsSync.add(new Thread(t::sync, "syncThread"));
        }

        long startSync = System.currentTimeMillis();

        for(Thread t1 : threadsSync) t1.start();
        for(Thread t1 : threadsSync) t1.join();

//        threadsSync.forEach(o->o.start());
//        threadsSync.forEach(o-> {
//            try {
//                o.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        long endSync = System.currentTimeMillis();

        System.out.println("atomic: " + t.countAtomic.get() + "   " + (end - start));
        System.out.println("synchronized: " + t.countSyn + "   " + (endSync - startSync));

    }

}
