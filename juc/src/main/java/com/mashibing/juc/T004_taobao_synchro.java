package com.mashibing.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
    淘宝面试题： 实现一个容器，提供两个方法，add、size, 写两个线程
        1、线程1，添加10个元素到容器
        2、线程2，实时监控元素个数，当个数到5时线程2给出提示并结束

 */
public class T004_taobao_synchro {

    List list = Collections.synchronizedList(new LinkedList<>());

    public void add(Object obj) {
        list.add(obj);
    }

    public long size() {
        return list.size();
    }

    public static void main(String[] args) {
        T004_taobao_synchro t004 = new T004_taobao_synchro();

        Thread t1 = new Thread(()->{
            for(int i=0; i< 10; i++) {
                t004.add(new Object());
                System.out.println("添加：" + (i + 1));

                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread t2 = new Thread(()->{
           while (true) {
               if (t004.size() == 5) {
                   System.out.println("到5了");
                   break;
               }
           }
            System.out.println("t2 退出");
        });
        t2.start();

        t1.start();

    }

}
