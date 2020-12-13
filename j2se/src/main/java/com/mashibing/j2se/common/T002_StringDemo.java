package com.mashibing.j2se.common;

import java.io.File;

public class T002_StringDemo {

    public static void main(String[] args) {

        String s1 = "abcde1";
        System.out.println(s1.codePointAt(0));
        System.out.println(s1.codePointBefore(1));
        System.out.println(s1.codePointCount(0,2));

        String s2 = "abcde1";

        System.out.println(s1.compareTo(s2));
        System.out.println(s1.startsWith("cd", 2));

        System.out.println(s2.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s2.indexOf(99));

//        System.out.println(String.join(File.separator, "c:", "windows", "system32"));
        String s3 = "abcabcedefeabcdfew";
        System.out.println(s3.lastIndexOf("abc"));
    }

    public static String con() {
//        String x = "a" + "b";
        String a = "a";
        String b = "a";
        String c = "a";
        String d = a + b + c;
//        int a = 1;
        return d;
    }
}
