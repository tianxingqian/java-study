package com.mashibing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"username"})
public class OutputController {

    /**
     * 若要将 username值放到session中， 需要在class上添加@SessionAttributes({"username"})
     * @param model
     * @return
     */
    @RequestMapping("/testSession")
    public String testSession(Model model) {
        model.addAttribute("username", "zhangsan");
        return "success";
    }
}
