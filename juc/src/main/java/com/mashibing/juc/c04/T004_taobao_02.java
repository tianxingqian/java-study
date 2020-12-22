package com.mashibing.juc.c04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
    淘宝面试题： 实现一个容器，提供两个方法，add、size, 写两个线程
        1、线程1，添加10个元素到容器
        2、线程2，实时监控元素个数，当个数到5时线程2给出提示并结束

 */
public class T004_taobao_02 {

//    List list = Collections.synchronizedList(new LinkedList<>());
    volatile List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public long size() {
        return list.size();
    }

    public static void main(String[] args) {
        T004_taobao_02 t004 = new T004_taobao_02();



        new Thread(()->{
            for(int i=0; i< 10; i++) {
                t004.add(new Object());
                System.out.println("添加：" + (i));

                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            while (true) {
                if (t004.size() == 5) {
                    System.out.println("到5了");
                    break;
                }
            }
            System.out.println("t2 退出");
        }).start();


    }

}
