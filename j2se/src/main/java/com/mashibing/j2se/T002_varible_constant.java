package com.mashibing.j2se;

public class T002_varible_constant {

    static  int x;
    public static void main(String[] args) {

        int a=0;
        int b=4;

        System.out.println(x);
//        int c = ++b + b ++;
//        System.out.println(c);
        int d =++b+b++;
        System.out.println(d);
        System.out.println(b);


    }
}
