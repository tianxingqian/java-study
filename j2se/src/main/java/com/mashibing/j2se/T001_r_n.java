package com.mashibing.j2se;

/*
 测试 \r  \n
 */
public class T001_r_n {

    public static void main(String[] args) {
        System.out.println("abc1111111111\rdefeee");        // defeee
        System.out.println("abc\ndef");     // abc  新行def
        System.out.println("abc\r\ndef");   // abc  新行def
        System.out.println("abc\n\rdef");   // abc  新行def
    }
}
