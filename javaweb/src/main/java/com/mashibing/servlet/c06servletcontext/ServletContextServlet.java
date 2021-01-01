package com.mashibing.servlet.c06servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletContextServlet get ");

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name", "zhangsan");

        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getServletContextName());
        System.out.println(servletContext.getRealPath("web.xml"));
        System.out.println(servletContext.getInitParameter("hello"));
        System.out.println(servletContext.getServerInfo());
        System.out.println(servletContext.getContext("/javaweb") == servletContext);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletContextServlet post");
        resp.getWriter().write((String)getServletContext().getAttribute("name"));
    }
}
