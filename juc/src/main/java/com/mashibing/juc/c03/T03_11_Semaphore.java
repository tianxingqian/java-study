package com.mashibing.juc.c03;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  信号量
 */
public class T03_11_Semaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4, true);


        Runnable r = ()->{
            try {
                semaphore.acquire();
                System.out.println("处理业务: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        for (int i=0; i<10; i++) {
            new Thread(r, "Thread-" + i).start();
        }

    }

}
