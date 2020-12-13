package com.mashibing.juc.c02;

import java.util.ArrayList;
import java.util.List;


/**
 *  volatile 并不能保证多线程同时修改变量带来的不一致问题
 *  {@link T02_01_volatile#m()}  需要使用synchronized保证线程安全
 */
public class T02_01_volatile {

    volatile int count = 0;

    synchronized void m() {
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        T02_01_volatile t2 = new T02_01_volatile();


        List<Thread> threads = new ArrayList<>();

        for (int i=0;i<10; i++) {

            Runnable r = ()->{
                t2.m();
            };
            Thread thread = new Thread(r);
            thread.start();

            threads.add(thread);
        }

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t2.count);

    }

}
