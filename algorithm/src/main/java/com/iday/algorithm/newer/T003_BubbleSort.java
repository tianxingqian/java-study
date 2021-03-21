package com.iday.algorithm.newer;


public class T003_BubbleSort {


    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 7, 2, 7, 9, 1, 2};
        print(a);
        bubbleSort2(a);
        print(a);
    }

    private static void bubbleSort(int[] a) {
        // 位置：0 1、1 2、2 3.。。 N-1 N 比较，前大则交换
        // 位置：0 1、1 2、。。。 N-2 N-1 ，前大则交换
        // 位置：0 1、1 2、。。。 N-3 N-2 ，前大则交换
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }


    private static void bubbleSort2(int[] a) {
        for (int end = a.length - 1; end >= 0; end--) {

            for (int i=0; i<end; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i+1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int smallIndex) {
        int b = a[i];
        a[i] = a[smallIndex];
        a[smallIndex] = b;
    }

}
