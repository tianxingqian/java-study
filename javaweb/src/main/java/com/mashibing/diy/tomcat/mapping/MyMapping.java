package com.mashibing.diy.tomcat.mapping;

import java.util.HashMap;

public class MyMapping {

    private static HashMap<String, String> mapping = new HashMap();

    static {
        mapping.put("/mytomcat", "com.mashibing.diy.tomcat.servlet.Servlet01");
    }

    public static HashMap<String, String> getMapping() {
        return mapping;
    }
}
