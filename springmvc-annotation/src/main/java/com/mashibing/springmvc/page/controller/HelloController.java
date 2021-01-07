package com.mashibing.springmvc.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 *
 * springmvc处理过程
 *  1、浏览器要发送一个请求 http://localhost:8080/springmvc/hello
 *  2、首先交给tomcat容器
 *  3、在web.xml文件中配置了DispatcherServlet的类，所以此时会由当前的DispatcherServlet来接受请求
 *  4、接受到请求之后找到对应的Controller，去Controller中寻找@RequestMapping注解标识的方法
 *  5、找到匹配的方法之后，执行方法的逻辑
 *  6、处理完成之后需要返回一个前端页面的名称，
 *  7、有视图处理器来根据名称映射到对应的jsp页面的路径
 *  8、DispatcherServlet拿到对应的路径地址之后返回给浏览器
 *
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    /*
        @RequestMapping表示用来匹配当前方法要处理的请求，其中/可以写也可以不写，一般推荐写上
        @RequestMapping可以添加在类上，也可以添加在方法上， 当添加在类上的时候表示给所有的当前类的方法钱添加一个访问路径
        什么时候需要在类上添加此注解？
           当包含多个Controller，通过在不同的Controller中包含同名的请求的时候，需要添加

        @RequestMapping的配置参数
            value： 匹配的请求
                    @RequestMapping(value = "/hello"）
                    value值可以进行模糊匹配：
                        ?: 代替任意一个字符
                        *: 代替多个字符
                        **:代替多层路径
                        如果能匹配到过个请求，那么优先是精确匹配，其次是模糊匹配
            method：标识请求的方式 GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE
            params：表示要求请求中必须包含的参数
                    必须包含username属性值 ：@RequestMapping(value="/hello", params={"username"})
                    不能包含的参数名称：@RequestMapping(value="/hello", params={"！username"})
                    必须包含username，age两个属性值，并且username的值为zhangsan：@RequestMapping( value = "/hello",params = {"username=zhangsan","age"})
            headers：表示限制请求头中的相关属性值，用来做请求的限制
                @RequestMapping( value = "/hello",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36"})
            consumers：限制请求中的Content-Type   请求时发生的数据格式
            produces: 限制请求中的Accept, 客户端接收返回的格式

     */
    @RequestMapping(value = "/hello",
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username=zhangsan", "age"},
//            headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"},
            consumes = {"text/html", "application/*"},
            produces = {"text/html"}
            )
    public String hello(Map map) {
        System.out.println(this.getClass().getName() + "#hello()");
        map.put("msg", "121");
        return "hello";
    }

    @RequestMapping(value = "/hello", produces = {"text/hello1"})
    public String hello1(Map map) {
        System.out.println(this.getClass().getName() + "#hello1()");
        map.put("msg", "121");
        return "hello";
    }

}
