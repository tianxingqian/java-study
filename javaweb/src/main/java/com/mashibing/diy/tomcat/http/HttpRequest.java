package com.mashibing.diy.tomcat.http;

import java.io.IOException;
import java.io.InputStream;

public class HttpRequest {

    private String method;
    private String url;

    public HttpRequest(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        String str = null;
        // 读取
        if((len = inputStream.read(buffer)) > 0) {
            str = new String(buffer, 0, len);
        }


        // 解析 GET /xxxx HTTP/1.1
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.method = params[0];
        this.url = params[1];
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
