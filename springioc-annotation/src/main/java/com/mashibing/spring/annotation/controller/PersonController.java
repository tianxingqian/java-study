package com.mashibing.spring.annotation.controller;


import com.mashibing.spring.annotation.dao.PersonDao;
import com.mashibing.spring.annotation.service.PersonService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.SortedMap;

@Controller
public class PersonController  {

    public PersonController() {
        System.out.println("PersonController 构造");
    }

    // @Autowired
    // @Qualifier("personService")
    @Resource(name = "personService")
    private PersonService personService2;

    public void save() {
        personService2.save();
    }


    @Autowired
    public void test(PersonDao personDao) {
        System.out.println("test======：" + personDao);
    }


    @Autowired
    public void test2(@Qualifier("personService2") PersonService personService) {
        System.out.println("test2===" + personService.getBeanName());
    }


}
