package com.iday.algorithm.newer;

public class T001_Print_bin {


    public static void print(int num) {

        for (int i=31; i>=0; i--) {
            System.out.print((num & 1 << i) == 0 ? "0" : "1");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int a = 10;
        print(a);

        print(-1);
        print(Integer.MIN_VALUE);

        // 相反数

        int b = 5;
        int c = -b;
        int d = ~ b + 1;    // b 的相反数，取反加1
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}
