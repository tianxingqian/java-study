package com.mashibing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class OriginAPIController {

    @RequestMapping("/api")
    public String api(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("request", request);
        session.setAttribute("session", session);
        return "success";
    }


    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("msg","model good world");
        return "success";
    }

    @RequestMapping("/modelMap")
    public String modelMap(ModelMap modelMap) {
        modelMap.addAttribute("msg","modelMap  good world");
        return "success";
    }

    @RequestMapping("/map")
    public String map(Map map) {
        map.put("msg","map good world");
        return "success";
    }

    @RequestMapping("/mv")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("msg", "modelandView");
        return modelAndView;
    }

}
