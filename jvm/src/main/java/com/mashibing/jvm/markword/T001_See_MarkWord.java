package com.mashibing.jvm.markword;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * -XX:+UseCompressedOops 压缩普通对象指针
 * -XX:+UseCompressedClassPointers  压缩类指针
 */
public class T001_See_MarkWord {
    public static void main(String[] args) {
        System.out.println("------------VM details---------------");
        System.out.println(VM.current().details());

//        Car car = new Car();
//        Car car = Car.builder()
//                .id(1)
//                .type("SUV")
//                .level('A')
//                .price(22.22)
//                .build();

        // 普通对象，输出car对象信息
//        System.out.println(ClassLayout.parseInstance(car).toPrintable());
//        System.out.println("==============");
//        // 锁定对象car，输出car对象头部信息
//        System.out.println(Thread.currentThread().getId());


        // main锁上
//        car.drive();
//        System.out.println("main === \n" + ClassLayout.parseInstance(car).toPrintable());
//
//        new Thread(() -> {
//            System.out.println("==========inThread===========" + Thread.currentThread().getId());
//            car.drive();
//            System.out.println(ClassLayout.parseInstance(car).toPrintable());
//
//        }, "MyThread01").start();


        System.out.println("--------------------------------");

//        int[] array = new int[3];
//        array[0] = 11;
//        array[1] = 22;
//        array[2] = 33;
//
//        System.out.println(ClassLayout.parseInstance(array).toPrintable());

    }


}
