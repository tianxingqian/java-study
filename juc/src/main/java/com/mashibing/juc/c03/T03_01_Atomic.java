package com.mashibing.juc.c03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T03_01_Atomic {

    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for(int i=0; i< 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        T03_01_Atomic t = new T03_01_Atomic();

        int threadSize = 10000;

        List<Thread> threads = new ArrayList<>();
        for(int i=0; i< threadSize; i++) {
            threads.add(new Thread(t::m, "Thread" + i));
        }
        long start = System.currentTimeMillis();
        threads.forEach(o->o.start());
        threads.forEach(o-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("atomic: " + t.count.get() + ", time: " + (end - start));

    }

}
