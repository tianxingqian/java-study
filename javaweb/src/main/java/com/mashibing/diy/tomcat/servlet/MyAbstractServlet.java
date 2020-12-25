package com.mashibing.diy.tomcat.servlet;

import com.mashibing.diy.tomcat.http.HttpRequest;
import com.mashibing.diy.tomcat.http.HttpResponse;

import java.io.IOException;

public abstract class MyAbstractServlet {

    abstract public void doGet(HttpRequest request, HttpResponse response) throws IOException;
    abstract public void doPost(HttpRequest request, HttpResponse response) throws IOException;

    public void service(HttpRequest request, HttpResponse response) throws IOException {
        if ("GET".equals(request.getMethod())) {
            doGet(request, response);
        } else if ("POST".equals(request.getMethod())) {
            doPost(request, response);
        }
    }

}
