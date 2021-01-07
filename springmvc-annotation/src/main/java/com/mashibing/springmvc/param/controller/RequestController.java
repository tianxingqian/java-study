package com.mashibing.springmvc.param.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {


    // @RequestParam
    @RequestMapping("/param")
    public String requestParam(String name) {
        System.out.println("name=" + name);
        return "success";
    }

    // @RequestHeader
    // @CookieValue


}
