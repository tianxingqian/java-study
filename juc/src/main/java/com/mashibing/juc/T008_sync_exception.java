package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 代码中出现异常
 *  出现程序乱入情况
 */
public class T008_sync_exception {

    int count = 0;

    public synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");

        while (true) {
            count ++;
            System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + ", count = " + count);



            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 在此抛出异常，抛出异常时锁会被释放。 要想继续执行需要try catch异常
            if (count % 5 == 0) {
                int i = 1/0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T008_sync_exception t = new T008_sync_exception();
        // 线程1
        new Thread(()->t.m(), "threadOne").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 线程2
        new Thread(()->t.m(), "threadTwo").start();
    }

}
