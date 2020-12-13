package com.mashibing.j2se.fortest;

public class Test {

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        if (!(a && b)) {
            System.out.print("!(a&&b)");
        } else if (!(a || b)) {
            System.out.println("!(a||b)");
        } else {
            System.out.println("ab");
        }
    }
}
