package com.mashibing.juc.c02;

import java.util.concurrent.TimeUnit;

/**
 *  锁对象不能修改，修改后会线程同步被破坏
 */
public class T02_03_LockObject_final {

//    final Object object = new Object();
    Object object = new Object();

    void m() {
        synchronized(object) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T02_03_LockObject_final t = new T02_03_LockObject_final();
        new Thread(t::m, "ThreadOne").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 重建第二线程
        new Thread(t::m, "ThreadTwo").start();
        // 不能修改锁对象变量
        t.object = new Object();


    }

}
