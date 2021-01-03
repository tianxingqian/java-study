package com.mashibing.spring.annotation.service;

import com.mashibing.spring.annotation.dao.PersonDao;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements BeanNameAware {
    private String beanName;
    @Autowired
    private PersonDao personDao;
    public void save() {
        System.out.println("save in service, bean=" + beanName);
        personDao.save();
    }

    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName() {
        return beanName;
    }
}
