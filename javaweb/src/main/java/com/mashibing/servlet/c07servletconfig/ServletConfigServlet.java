package com.mashibing.servlet.c07servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");

        ServletConfig config = getServletConfig();

        System.out.println(config.getServletName());
        System.out.println(config.getServletContext() == getServletContext());
        System.out.println(config.getInitParameter("heheda"));

        Enumeration initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            String name = (String)initParameterNames.nextElement();
            System.out.println(name + ":" + config.getInitParameter(name));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
    }
}
