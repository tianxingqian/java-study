package com.mashibing.juc.c03;

import java.util.concurrent.locks.ReentrantLock;

public class T03_06ReentrantLock_fair implements Runnable {

    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T03_06ReentrantLock_fair r = new T03_06ReentrantLock_fair();

        new Thread(r, "t1").start();
        new Thread(r, "t2").start();
        new Thread(r, "t3").start();
        new Thread(r, "t4").start();
    }
}
