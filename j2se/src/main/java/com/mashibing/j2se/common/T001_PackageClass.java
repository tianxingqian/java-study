package com.mashibing.j2se.common;

/**
 *  基本数据类型的包装类
 */
public class T001_PackageClass {

    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);   // true     // 有个内存缓存  -128 ~ 127
        System.out.println(i3 == i4);   // false    查看Integer的valueOf实现

        Integer i5 = new Integer(100);
        System.out.println(i1 == i5);   // false
        System.out.println(i1 == 100);  // true




    }
}
