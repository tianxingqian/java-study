package com.iday.algorithm.newer;


public class T002_SelectSort {


    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 7, 2, 7, 9, 1,2};
        print(a);
        selectSort(a);
        print(a);
    }

    private static void selectSort(int[] a) {
        // 0 ~ n  找出最小的位置与第0个交换
        // 1 ~ n  找出最小的位置与第1个交换
        for (int i = 0; i < a.length; i++) {
            int smallIndex = i;
            for (int j= i+1; j<a.length; j++) {
                smallIndex = a[smallIndex] > a[j] ? j : smallIndex;
            }
            swap(a, i, smallIndex);
        }

    }

    private static void swap(int[] a, int i, int smallIndex) {
        int b = a[i];
        a[i] = a[smallIndex];
        a[smallIndex] = b;
    }

}
