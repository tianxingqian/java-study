package com.mashibing.servlet.c02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RequRespServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        System.out.println("GET");
        // getRequestURL：获取客户端的完整URL
        //getRequesURI：获取请求行中的资源名部分
        // getQueryString：获取请求行的参数部分
        // getMethod：获取请求方式
        // getSchema：获取请求的协议
        // getRemoteAddr：获取客户端的ip地址
        //getRemoteHost：获取客户端的完整主机名
        //getRemotePort：获取客户端的网络端口号
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
        System.out.println(req.getMethod());
        System.out.println(req.getScheme());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemotePort());

        // 获取header信息
        System.out.println("====================");
        System.out.println(req.getHeader("User-Agent"));
        Enumeration headerNames = req.getHeaderNames();
        for (; headerNames.hasMoreElements(); ) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + " : " + req.getHeader(key));
        }

        Enumeration headers = req.getHeaders("sec-ch-ua");
        for (; headers.hasMoreElements(); ) {
            String key = (String) headers.nextElement();
            System.out.println(key + " : " + req.getHeader(key));
        }

        // 获取参数
        System.out.println("=========获取参数=========");
        System.out.println(req.getParameter("name"));
        Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = String.valueOf(parameterNames.nextElement());
            System.out.println(key + " - " + req.getParameter(key));
        }

        System.out.println("-获取多个value的参数-");
        String[] favs = req.getParameterValues("fav");
        if (favs != null)
            for (String fav : favs) {
                System.out.println(fav);
            }

        // response
        resp.setHeader("abc", "abc");
        resp.addHeader("tt", "aaa");
        resp.addHeader("tt", "abc");

        resp.getWriter().write("fffffffffffffff");
        resp.sendError(404, "fefefe");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        System.out.println("POST");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("<h1>tetela你好</h1>");

        System.out.println(req.getParameter("name"));
    }

}
