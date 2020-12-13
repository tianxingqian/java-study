package com.mashibing.juc.c03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class T03_07_CountDownLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        List<Thread> threads = new ArrayList<>();

        for (int i=0; i<100; i++) {
            threads.add(new Thread(()->{
                int result = 0;
                for (int j=0; j< 10000; j++) {
                    result += j;
                }
                latch.countDown();
                System.out.println("latch down ");
            }));
        }
        threads.forEach(o->o.start());

        try {
            System.out.println("await");
            latch.await();
            System.out.println("go ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("latch end ");
    }
}
