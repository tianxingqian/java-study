package com.mashibing.j2se.collection;

import java.util.HashSet;
import java.util.TreeSet;

public class T006_set {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(6);
        hashSet.add(10);
        hashSet.add(9);
        hashSet.add(12);
        hashSet.add(11);
        System.out.println(hashSet);

        // 类型要一样，不然没发比较
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        System.out.println(treeSet);

        TreeSet treeSetStr = new TreeSet();
        treeSetStr.add("a");
        treeSetStr.add("b");
        treeSetStr.add("c");
        treeSetStr.add("d");
        treeSetStr.add("e");
        System.out.println(treeSetStr);

    }
}
