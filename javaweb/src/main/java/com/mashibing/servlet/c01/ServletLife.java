package com.mashibing.servlet.c01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletLife extends HttpServlet {

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletLife destroy");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("ServletLife init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fffff");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
    }
}
