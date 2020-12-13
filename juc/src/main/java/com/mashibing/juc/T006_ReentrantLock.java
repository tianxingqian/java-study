package com.mashibing.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T006_ReentrantLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread One run");
                TimeUnit.SECONDS.sleep(6);
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }, "threadOne").start();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread Two run");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }, "threadTwo").start();

    }

}
