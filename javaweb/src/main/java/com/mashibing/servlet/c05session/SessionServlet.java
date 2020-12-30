package com.mashibing.servlet.c05session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("session servlet get");
        String name = (String) req.getSession().getAttribute("name");
        if (name != null)
            resp.getWriter().write(name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("session servlet");
        req.getSession().setAttribute("name", req.getParameter("name"));


    }
}
