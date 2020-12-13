package com.mashibing.juc.c03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class T03_05_ReentrantLock_interruptibly {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                TimeUnit.DAYS.sleep(10);
                System.out.println("t1 end....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            try {
                lock.lockInterruptibly();
                System.out.println("t2 start....");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end...");
            } catch (Exception e) {
                System.out.println("异常了");
                e.printStackTrace();
            } finally {
                System.out.println(lock.isLocked());
                if (lock.isLocked())  lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();

    }

}
