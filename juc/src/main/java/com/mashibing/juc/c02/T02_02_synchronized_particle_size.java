package com.mashibing.juc.c02;


import java.util.concurrent.TimeUnit;

/**
 * 锁的粒度
 * {@link T02_02_synchronized_particle_size#m1()}  粗粒度锁
 * {@link T02_02_synchronized_particle_size#m2()}  细粒度锁
 *
 */
public class T02_02_synchronized_particle_size {

    int count =0;

    synchronized void m1() {

        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 业务逻辑只有 这句需要同步，这时候不需要整个方法上加锁
        count ++;

        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 业务逻辑只有 这句需要同步， 采用细粒度锁
        synchronized (this) {
            count ++;
        }

        // 模拟业务逻辑
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
