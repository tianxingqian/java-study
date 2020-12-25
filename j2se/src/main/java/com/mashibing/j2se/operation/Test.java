package com.mashibing.j2se.operation;

public class Test {

    public static void main(String[] args) {
        int a = 6;
        int b = 11;

//        a++;
//        ++a;

//        b = ++a;
//        b = a++;

//        b += 5;

//        b += a++;

//        b = a & b;
//        b = a | b;
//        b = a ^ b;

//        b *= 5;
//        b = b % 5;
//        b = b > 5 ? 15 : 99;
        b = ++a+a++;
        System.out.println(a);
//        System.out.println(a & b);
//        System.out.println(a | b);
//        System.out.println(a ^ b);
//        System.out.println(Integer.toBinaryString(a));
//        // 11111111111111111111111111111001  补码，符号位不变，其余位取反+1  -100。。。0000111
//        System.out.println(Integer.toBinaryString(~a)); //  -7   负数用补码表示， 符号位不变，其他位取反加1
//
//        int c = 0b00111100;
//        System.out.println(Integer.toBinaryString(~c));
//
//        System.out.println(1 << 4);

//        a++;
//        b += 5;
//        b += a + 111;
//        b = b + 6;
    }

}
