package com.mashibing.juc.c04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;


public class T04_01_LockSupport {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
           for (int i=0; i<10; i++) {
               System.out.println(i);
               if (i == 5) {
                   LockSupport.park();
               }
               if (i == 8) {
                   LockSupport.park();
               }
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        t.start();
        // 唤醒线程t  唤醒线程t
        LockSupport.unpark(t);
        System.out.println("唤醒了");
        LockSupport.unpark(t);
    }
}
