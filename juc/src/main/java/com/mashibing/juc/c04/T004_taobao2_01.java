package com.mashibing.juc.c04;

import java.util.LinkedList;

/**
 * 写一个固定容量的容器，拥有put、get、getCount，支持2个生产者、10个消费者，阻塞调用
 */
public class T004_taobao2_01<T> {

    private LinkedList<T> linkedList = new LinkedList<>();
    private int count = 10;

    public synchronized void put(T t) {
        while (linkedList.size() == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (linkedList.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = linkedList.removeFirst();
        count --;
        notifyAll();
        return t;
    }

    public static void main(String[] args) {
        T004_taobao2_01<String> c = new T004_taobao2_01();
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
