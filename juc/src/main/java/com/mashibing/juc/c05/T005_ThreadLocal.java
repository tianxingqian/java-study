package com.mashibing.juc.c05;

public class T005_ThreadLocal {

    public static void main(String[] args) {

        ThreadLocal<Object> tl = new ThreadLocal<>();
        tl.set(new Object());
        tl.remove();

    }
}
