package com.mashibing.j2se.exception;

public class TryFinally {

    public static void main(String[] args) {
        System.out.println("main " + test());
        System.out.println("=======================");
        System.out.println("main " + test1());
    }

    private static int test() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        } finally {
            if (num > 20) {
                System.out.println("num > 20: " + num);
            }
            System.out.println("finally");
            num = 100;
            return num;
        }

    }


    private static int test1() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        } finally {
            if (num > 20) {
                System.out.println("num > 20: " + num);
            }
            System.out.println("finally");
            num = 100;
            System.out.println("finally num=" + num);
        }
        return num;
    }

    private static int test2() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        } finally {
            System.out.println("finally");
            num = 100;
            return num;
        }

    }
}
