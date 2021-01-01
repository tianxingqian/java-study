package com.mashibing.servlet.c06servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletContextServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletContextServlet get ");

        ServletContext servletContext = getServletContext();
        resp.getWriter().write((String)getServletContext().getAttribute("name"));

        Enumeration attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = (String)attributeNames.nextElement();
            System.out.println(servletContext.getAttribute(name));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletContextServlet post");
        resp.getWriter().write((String)getServletContext().getAttribute("name"));
    }
}
