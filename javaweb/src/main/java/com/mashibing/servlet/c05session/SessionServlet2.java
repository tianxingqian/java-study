package com.mashibing.servlet.c05session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.SortedMap;

public class SessionServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SessionServlet2 get");
        req.getSession().invalidate();
        // session失效
        System.out.println("session invalidate");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SessionServlet2 post");
        req.getSession().setMaxInactiveInterval(3600);

    }
}
