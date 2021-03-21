package com.iday.algorithm.newer;


public class T004_InsertSort {


    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 7, 2, 7, 9, 1, 2};
        print(a);
        insertSort2(a);
        print(a);
    }

    private static void insertSort(int[] a) {
        // 0 ~ 1  有序
        // 0 ~ 2 有序
        // 0 ~ 3 有序
        for (int end = 1; end < a.length; end++) {
            for (int pre = end - 1; pre >= 0 && a[pre] > a[pre + 1]; pre--) {
                swap(a, pre, pre + 1);
            }
        }

    }

    private static void insertSort2(int[] a) {
        // 0 ~ 1  有序
        // 0 ~ 2 有序
        // 0 ~ 3 有序
        for (int end = 1; end < a.length; end++) {
            int newIndex = end-1;
            while(newIndex >=0) {
                if (a[newIndex] > a[newIndex + 1]) {
                    swap(a, newIndex, newIndex + 1);
                }
                newIndex --;
            }
        }

    }


    private static void swap(int[] a, int i, int smallIndex) {
        int b = a[i];
        a[i] = a[smallIndex];
        a[smallIndex] = b;
    }

}
