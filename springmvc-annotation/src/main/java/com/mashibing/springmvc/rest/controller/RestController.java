package com.mashibing.springmvc.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {


    @RequestMapping("/rest")
    public String page() {
        System.out.println("page");
        return "rest";
    }

    //Representational State Transfer : 表述性状态传递

    @RequestMapping(value = "/user", method = {RequestMethod.POST})
    public String add() {
        System.out.println("add");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = {RequestMethod.GET})
    public String query(@PathVariable("id") Integer id) {
        System.out.println("query");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = {RequestMethod.DELETE})
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("delete" + id);
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = {RequestMethod.PUT})
    public String update(@PathVariable("id") Integer id) {
        System.out.println("update");
        return "success";
    }



}
