package com.mashibing.j2se.exception;

public class T001_DefineException {

    public static void main(String[] args)  {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main 输出");
    }

    public static void test() throws Exception{
        System.out.println(1/0);
    }
}
