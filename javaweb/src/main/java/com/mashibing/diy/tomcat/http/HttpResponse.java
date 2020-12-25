package com.mashibing.diy.tomcat.http;

import java.io.IOException;
import java.io.OutputStream;

public class HttpResponse {

    private OutputStream outputStream;

    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>")
                .append(str)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        outputStream.write(stringBuilder.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
