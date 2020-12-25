package com.mashibing.juc.c04;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量的容器，拥有put、get、getCount，支持2个生产者、10个消费者，阻塞调用
 * 使用条件将 生产者、消费者 分类唤醒
 * consumerCon.await(); // 容器中数据为0时， 消费者 等待
 * producureCon.signalAll();    // 同时唤醒生产者
 *
 * producureCon.await();    // 容器中数据满了， 生产者等待
 * consumerCon.signalAll(); // 同时唤醒消费者
 */
public class T004_taobao2_02_condition<T> {

    private LinkedList<T> linkedList = new LinkedList<>();
    private int count = 10;
    private ReentrantLock lock = new ReentrantLock();
    private Condition producureCon = lock.newCondition();
    private Condition consumerCon = lock.newCondition();


    public void put(T t) {
        try {
            lock.lock();
            while (linkedList.size() == 10) {
                System.out.println("满了");
                try {
                    producureCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumerCon.signalAll();
            }
            linkedList.add(t);
            ++count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (linkedList.size() == 0) {
                System.out.println("空了");
                try {
                    consumerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = linkedList.removeFirst();
            count--;
            producureCon.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        T004_taobao2_02_condition<String> c = new T004_taobao2_02_condition();
        // 消费者线程
        for (int i =0; i< 10; i++) {
            new Thread(()->{
                for (int j=0; j<5; j++) System.out.println(c.get());
            }, "Consumer" + i).start();
        }
        // 生产者
        for (int i=0; i<2; i++) {
            new Thread(()->{
                for (int j=0; j<25; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
