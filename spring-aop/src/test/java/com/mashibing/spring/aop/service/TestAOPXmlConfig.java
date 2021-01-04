package com.mashibing.spring.aop.service;

import com.mashibing.spring.aop.proxy.MyProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOPXmlConfig {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");
        Calculate calculate = context.getBean("myCalculate", Calculate.class);
        System.out.println(calculate.add(1, 1));
        System.out.println(calculate.getClass());
    }

}
