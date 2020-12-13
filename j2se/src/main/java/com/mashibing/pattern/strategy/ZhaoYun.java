package com.mashibing.pattern.strategy;

public class ZhaoYun {

    public static void main(String[] args) {
        Context context;
        // 刚到吴国时候 拆开第一个
        System.out.println("------刚刚到吴国的时候拆第一个-----");
        context = new Context(new First());
        context.operate();
        System.out.println("\n\n\n\n\n");

        // 刘备乐不思蜀了， 拆第二个
        System.out.println("----------刘备乐不思蜀了， 拆第二个--------");
        context = new Context(new Second());
        context.operate();
        System.out.println("\n\n\n\n\n");

        // 孙权的追兵到了， 拆第三个
        System.out.println("---------孙权的小兵追了，咋办？拆第三个-------");
        context = new Context(new Third());
        context.operate();
        System.out.println("\n\n\n\n\n\n");
    }

}
