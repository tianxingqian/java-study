package com.mashibing.spring.annotation;

import com.mashibing.spring.annotation.controller.PersonController;
import com.mashibing.spring.annotation.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonController personController = context.getBean("personController", PersonController.class);
        System.out.println(personController);
        personController.save();

        PersonService personService = context.getBean("personService", PersonService.class);
        System.out.println();
    }

}
