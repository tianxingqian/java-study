package com.mashibing.spring.fanxing;

import com.mashibing.spring.fanxing.controller.MyController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFan {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyController myController = context.getBean("myController", MyController.class);
        myController.test();
        myController.test2();
    }
}
