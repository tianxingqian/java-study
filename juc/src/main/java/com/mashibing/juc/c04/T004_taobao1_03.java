package com.mashibing.juc.c04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
    淘宝面试题： 实现一个容器，提供两个方法，add、size, 写两个线程
        1、线程1，添加10个元素到容器
        2、线程2，实时监控元素个数，当个数到5时线程2给出提示并结束

 */
public class T004_taobao1_03 {

    volatile List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public long size() {
        return list.size();
    }

    public static void main(String[] args) {
        T004_taobao1_03 t004 = new T004_taobao1_03();

        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 开始");
                if (t004.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 退出");
                lock.notify();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    t004.add(new Object());
                    System.out.println("添加：" + (i));
                    if (t004.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1").start();
    }
}
