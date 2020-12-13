package com.mashibing.juc.c03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  可重入锁
 */
public class T03_03_ReentrantLock {

    ReentrantLock lock = new ReentrantLock();


    void m()  {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void m2() {
        try {
            lock.lock();
            System.out.println("m2......");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T03_03_ReentrantLock t = new T03_03_ReentrantLock();

        new Thread(t::m, "threadOne").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t::m2, "threadTwo").start();


    }

}
