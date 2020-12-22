package com.mashibing.juc.c03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class T03_04_ReentrantLock_tryLock {

    ReentrantLock lock = new ReentrantLock();

    void m1() {
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
        }finally {
            lock.unlock();
        }
    }

    void m2() {
        boolean flag = false;
        try {
//            flag = lock.tryLock();
            flag = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 ....., locked=" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T03_04_ReentrantLock_tryLock t = new T03_04_ReentrantLock_tryLock();

        new Thread(t::m1, "threadOne").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(t::m2, "threadTwo").start();


    }

}
