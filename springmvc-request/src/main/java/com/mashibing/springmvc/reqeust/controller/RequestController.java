package com.mashibing.springmvc.reqeust.controller;

import com.mashibing.springmvc.reqeust.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.management.Agent;

@Controller
public class RequestController {


    /**
     * request.getParameter("name")
     *
     * 当发送请求的时候，找到对应的处理方法之后，会根据参数的名称从request中获取对应的参数值，并封装到方法中
     * 此时要求，方法的名字和url中参数的名字必须一致，如果不一致，设置不成功
     *
     * 如果设置的值不同，同时又想让参数获取到对应的属性值，可以通过@RequestParam来使用
     * 经常跟@PathVariable混淆，主要注意，两个注解有不同的用处
     * 次注解的参数：
     *      value:获取的参数值
     *      required：表示当前属性值是否是必须存在的，默认值是true,表示请求中必须要包含此参数，如果没有，400，bad request
     *      defaultValue:如果传递参数了，那么使用传递进来的参数，如果没有使用默认值
     * @param name
     * @return
     */
    // @RequestParam
    @RequestMapping("/param")
    public String requestParam(@RequestParam(value = "username", required = true, defaultValue = "zhangsan") String name) {
        System.out.println("name=" + name);
        return "success";
    }

    /**
     * 获取请求头信息：
     * 通过@RequestHeader注解来表示
     *      request.getHeader("User-Agent")
     *
     *      同时也包含了几个参数
     *         value：
     *         required：
     *         defaultValue:
     *         同@RequestParam
     * @param agent
     * @return
     */
    // @RequestHeader
    @RequestMapping("/header")
    public String reqeustHeader(@RequestHeader("User-Agent") String agent) {
        System.out.println("agent=" + agent);
        return "success";
    }

    /*
     *
     * 获取cookie中的值，使用@CookieValue注解
     *      Cookie[] cookies = request.getCookies();
     *       同时也包含了几个参数
     *               value：
     *               required：
     *               defaultValue:
     *               同@RequestParam
     * @param jsessonId
     * @author Will
     * @date 2021/1/7 22:41
     * @return java.lang.String
     */
    // @CookieValue
    @RequestMapping("/cookie")
    public String reqeustCookie(@CookieValue (value = "JSESSIONID", required = true) String jsessonId) {
        System.out.println("JSESSIONID=" + jsessonId);
        return "success";
    }


    @RequestMapping("page")
    public String getAddPage() {
        return "add";
    }

    /*** 功能描述:
    * @param:
    * @return:
    * @auther:
    * @date:
    */
    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }

}
