package com.iday.pattern.singleton;

public class Test {


    public static void main(String[] args) {
        // test01();

        // test02();
        // test03();
        // test04();
        // test05();
        // test06();
        test07();

    }

    private static void test07() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton07.INSTANCE.hashCode());
            }).start();
        }
    }

    private static void test06() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
    }

    private static void test05() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }

    private static void test04() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }

    private static void test03() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }

    private static void test02() {
        for (int i = 0; i< 100; i++) {
            new Thread(()->{
                System.out.println(Singleton02.getInstance().hashCode());
            }).start();
        }
    }

    private static void test01() {
        for (int i = 0; i< 1000; i++) {
            new Thread(()->{
                System.out.println(Singleton01.getInstance().hashCode());
            }).start();
        }
    }

}
