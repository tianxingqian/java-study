package com.mashibing.juc.c03;

import java.util.concurrent.Exchanger;

public class T03_12_Exchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(()->{
            String s1 = "T1";
            try {
                s1 = exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": s1=" + s1);
        }, "ThreadOne").start();

        new Thread(()->{
            String s2 = "T2";
            try {
                s2 = exchanger.exchange(s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": s2=" + s2);
        }, "ThreadTwo").start();
    }
}
