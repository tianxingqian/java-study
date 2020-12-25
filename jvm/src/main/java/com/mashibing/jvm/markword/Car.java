package com.mashibing.jvm.markword;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
@Builder
public class Car {
    private int id;
    private String type;
    private double price;
    private char level;

//    public synchronized void drive()  {
//        System.out.println("drive ---");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
