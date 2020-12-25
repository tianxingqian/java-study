package com.mashibing.diy.tomcat.server;

import com.mashibing.diy.tomcat.http.HttpRequest;
import com.mashibing.diy.tomcat.http.HttpResponse;
import com.mashibing.diy.tomcat.mapping.MyMapping;
import com.mashibing.diy.tomcat.servlet.MyAbstractServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {


    public static void startServer(int port) throws Exception {

        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = null;

        while (true) {
            socket = serverSocket.accept();

            // 获取输入流、输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            HttpRequest httpRequest = new HttpRequest(inputStream);
            HttpResponse httpResponse = new HttpResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(httpRequest.getUrl());
            if (clazz != null) {
                Class<MyAbstractServlet> myAbstractServletClass = (Class<MyAbstractServlet>) Class.forName(clazz);
                MyAbstractServlet myAbstractServlet = myAbstractServletClass.getDeclaredConstructor().newInstance();
                myAbstractServlet.service(httpRequest, httpResponse);
            }

        }

    }

    public static void main(String[] args) {
        try {
            startServer(9999);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
