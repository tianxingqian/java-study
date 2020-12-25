package com.mashibing.diy.tomcat.servlet;

import com.mashibing.diy.tomcat.http.HttpRequest;
import com.mashibing.diy.tomcat.http.HttpResponse;

import java.io.IOException;

public class Servlet01 extends MyAbstractServlet {

    @Override
    public void doGet(HttpRequest request, HttpResponse response) throws IOException {
        response.write("mytomcat get");
    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) throws IOException {
        response.write("Post mytomcat");

    }
}
