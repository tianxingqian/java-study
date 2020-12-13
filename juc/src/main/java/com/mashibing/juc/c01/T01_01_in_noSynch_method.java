package com.mashibing.juc.c01;

import java.util.concurrent.TimeUnit;

/*
    测试目的：验证当对象在锁定状态时，其他线程是否可以访问非synchronize方法
    Person 类有两个方法，A、B
        1、A是 synchronize
        2、B是没有synchronize
    threadOne、threadTwo两个线程，访问person对象方法
        threadOne访问 A方法，并sleep 10秒
        期间，threadTwo 是否能访问 B方法

 */
public class T01_01_in_noSynch_method {

    public static void main(String[] args) throws InterruptedException {

        Person person = new Person();

        new Thread(() -> {
            person.A();
            System.out.println(Thread.currentThread().getName() + ": 执行完A， 开始sleep");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 执行完A， 完成sleep");

        }, "threadOne").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            person.B();
        }, "threadTwo").start();
    }


}

class Person {
    public synchronized void A() {
        System.out.println("method A  execute ");
    }

    public void B() {
        System.out.println("method B execute ");
    }

}


