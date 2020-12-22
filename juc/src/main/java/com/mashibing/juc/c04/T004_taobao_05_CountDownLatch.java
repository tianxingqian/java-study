package com.mashibing.juc.c04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
    淘宝面试题： 实现一个容器，提供两个方法，add、size, 写两个线程
        1、线程1，添加10个元素到容器
        2、线程2，实时监控元素个数，当个数到5时线程2给出提示并结束
    双重门闩
 */
public class T004_taobao_05_CountDownLatch {

    volatile List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public long size() {
        return list.size();
    }

    public static void main(String[] args) {
        T004_taobao_05_CountDownLatch t004 = new T004_taobao_05_CountDownLatch();

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 开始");
            if(t004.size() != 5) {
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch1.countDown();
            }
            System.out.println("t2 退出");

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                t004.add(new Object());
                System.out.println("添加：" + (i));
                if (t004.size() == 5) {
                    latch2.countDown();
                    try {
                        latch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }, "t1").start();


    }

}
