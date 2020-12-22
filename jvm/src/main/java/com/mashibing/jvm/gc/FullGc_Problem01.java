package com.mashibing.jvm.gc;

import com.mashibing.jvm.markword.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 运行参数配置： -XX:+PrintGCDetails -Xms50M -Xmx50M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/my_jvm/dump/dump.dump
  java -XX:+PrintGCDetails -Xms50M -Xmx50M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/my_jvm/dump/dump.dump  com.mashibing.jvm.gc.FullGc_Problem01
 */
public class FullGc_Problem01 {
    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birthday = new Date();
        public void m(){}
    }

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);
        for (;;){
            modelFit();
            Thread.sleep(100);
        }
    }


    private static void modelFit() {
        List<CardInfo> taskList = getAllCardInfo();
        for (CardInfo item: taskList) {
            executor.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    item.m();
                }
            }, 2, 3, TimeUnit.SECONDS);
        }

//        for (CardInfo item: taskList) {
//            executor.scheduleWithFixedDelay(() -> {
//                item.m();
//            }, 2, 3, TimeUnit.SECONDS);
//        }

//        taskList.forEach(info -> {
//            executor.scheduleWithFixedDelay(() -> {
//                info.m();
//            }, 2, 3, TimeUnit.SECONDS);
//        });
    }

    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> taskList = new ArrayList<>();
        for (int i=0; i<100; i++) {
//            CardInfo ci = new CardInfo();
            taskList.add(new CardInfo());
        }
        return taskList;
    }
}
