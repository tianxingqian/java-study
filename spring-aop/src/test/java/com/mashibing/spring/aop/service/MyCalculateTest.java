package com.mashibing.spring.aop.service;

import com.mashibing.spring.aop.proxy.MyProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyCalculateTest {


    @Test
    public void add() {
        Calculate calculate = new MyCalculate();
        Calculate calculateProxy = new MyProxy().getProxy(calculate);
        System.out.println(calculateProxy.add(1, 1));
    }

    @Test
    public void addSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Calculate calculate = context.getBean("myCalculate", Calculate.class);
        System.out.println(calculate.add(1, 1));
        System.out.println(calculate.getClass());
    }

    @Test
    public void testCglib() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        MyCalculate2 calculate = context.getBean("myCalculate2", MyCalculate2.class);
        System.out.println(calculate.add(1, 1));
        System.out.println(calculate.getClass());
    }
}
