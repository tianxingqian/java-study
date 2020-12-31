package com.mashibing.servlet.c04cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cookie servlet");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }

        Cookie cookie = new Cookie("name", "delta");
        resp.addCookie(cookie);

        Cookie token = new Cookie("token", "12314afa31faff4qf");
        token.setMaxAge(7 * 24 * 3600);
        token.setMaxAge(0);
        resp.addCookie(token);


    }
}
