package com.mashibing.springmvc.controller;


import com.mashibing.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/updatePage")
    public String page() {

        return "update";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("user") User user, Model model) {
        System.out.println("update========");
        System.out.println(user);


        return "success";
    }

    @ModelAttribute
    public void model(Model model) {
        System.out.println("====ModelAttribute====model==============");
        User user = new User();
        user.setId(1);
        user.setName("张三1");
        user.setAge(40);
        model.addAttribute("user", user);
    }

    @ModelAttribute("user")
    public User user() {
        System.out.println("=======ModelAttribute===user============");
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(30);

        return user;

    }
}
