package com.mashibing.spring.fanxing.controller;

import com.mashibing.spring.fanxing.model.Student;
import com.mashibing.spring.fanxing.model.Teacher;
import com.mashibing.spring.fanxing.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @Autowired
    BaseService<Student> baseService;
    @Autowired
    BaseService<Teacher> baseService1;

    public void test() {
        baseService.save();
    }

    public void test2() {
        baseService1.save();
    }

}
