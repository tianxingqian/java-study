package com.mashibing.juc.c03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class T03_08_CyclicBarrier {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, ()->{
            System.out.println("满20人，发车");
        });

        for (int i=0; i< 102; i++) {
            new Thread(()->{
                try {
                    cyclicBarrier.await(10, TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();
        }
    }

}
