package com.mashibing.springmvc.page.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // 创建模型和视图对象
        ModelAndView mv = new ModelAndView();
        // 将需要的值传到model中
        mv.addObject("msg", "Hello SpringMVC");
        // 设置要调整的视图
        mv.setViewName("hello");

        return mv;
    }
}
