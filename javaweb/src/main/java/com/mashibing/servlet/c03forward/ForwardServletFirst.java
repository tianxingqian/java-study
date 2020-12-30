package com.mashibing.servlet.c03forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardServletFirst extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet first");
        req.setCharacterEncoding("utf-8");
        req.setAttribute("name", "zhangsan");

        req.getRequestDispatcher("/forward2").forward(req,resp);
    }
}
