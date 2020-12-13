package com.mashibing.juc.c03;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T03_10_ReadWriteLock {

    private static int value;

    void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " read over ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println(Thread.currentThread().getName() + " finish write ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();

        T03_10_ReadWriteLock t = new T03_10_ReadWriteLock();

        Runnable readR = () -> t.read(lock);
        Runnable readR2 = () -> t.read(readLock);

        Runnable write = () -> t.write(lock, new Random().nextInt());
        Runnable write2 = () -> t.write(writeLock, new Random().nextInt());

        for (int i = 0; i < 10; i++) new Thread(readR, "lock").start();
        for (int i = 0; i < 2; i++) new Thread(write, "normal lock").start();

        for (int i = 0; i < 10; i++) new Thread(readR2, "readLock").start();
        for (int i = 0; i < 2; i++) new Thread(write2, "writeLock").start();

    }

}
