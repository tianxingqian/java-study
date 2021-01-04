package com.mashibing.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MyCalculate  implements Calculate{
    public int add(int a, int b) {
        int c = a + b;
        // int i = 1/0;
        System.out.println("add 运算");
        return c;
    }
}
