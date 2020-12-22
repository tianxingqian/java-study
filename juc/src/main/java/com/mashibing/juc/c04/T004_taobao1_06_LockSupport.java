package com.mashibing.juc.c04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/*
    淘宝面试题： 实现一个容器，提供两个方法，add、size, 写两个线程
        1、线程1，添加10个元素到容器
        2、线程2，实时监控元素个数，当个数到5时线程2给出提示并结束
    LockSupport
 */
public class T004_taobao1_06_LockSupport {
    volatile List list = new ArrayList();
    public void add(Object obj) {
        list.add(obj);
    }
    public long size() {
        return list.size();
    }
    static Thread t1, t2;

    public static void main(String[] args) {
        T004_taobao1_06_LockSupport t004 = new T004_taobao1_06_LockSupport();

        t2 = new Thread(() -> {
            System.out.println("t2 开始");
            if (t004.size() != 5) {
                LockSupport.park();
            }
            System.out.println("t2 退出");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t004.add(new Object());
                System.out.println("添加：" + (i));
                if (t004.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");
        t1.start();
    }
}
