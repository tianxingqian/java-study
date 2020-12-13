package com.mashibing.j2se.collection;

import java.util.*;

public class T001_collection {

    public static void main(String[] args) {

        Collection collection = new ArrayList();

        collection.add(1);
        collection.add(1.2345);
        collection.add("abcd");
        collection.add(true);
        collection.add('a');
        collection.add('b');

        System.out.println(collection);

        Collection collection1 = new LinkedList();
        collection1.add("a");
        collection1.add("b");
        collection1.add("c");
        collection1.add("d");
        collection.addAll(collection1);

        System.out.println(collection);

        System.out.println(collection.retainAll(collection1));
        System.out.println("==========");
        collection1.remove("a");
        System.out.println(collection1);
//        collection.removeAll(collection1);
        System.out.println(collection);
        collection1.clear();
        System.out.println(collection1);

        System.out.println("=====set========");
        Set set = new HashSet();
        set.add("a");
        set.add("abc");
        set.addAll(collection);

        System.out.println(set);

    }
}
