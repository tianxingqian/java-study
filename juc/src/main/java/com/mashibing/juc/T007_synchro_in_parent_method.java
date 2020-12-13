package com.mashibing.juc;

import java.util.concurrent.TimeUnit;

/**
 *  A继承B类
 *    A.m()是synchronized; B.m()也是synchronized
 *    在B.m()中调用super.m()
 */
public class T007_synchro_in_parent_method {

    public synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end ");

    }

    public static void main(String[] args) {
        Runnable runnable = ()-> new TT().m();
        new Thread(runnable).start();
    }

}

class TT extends T007_synchro_in_parent_method{
    @Override
    public synchronized void m() {
        System.out.println("child start");
        super.m();
        System.out.println("child end");

    }
}
