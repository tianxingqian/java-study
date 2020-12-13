package com.mashibing.j2se.collection;

import java.util.*;

public class T002_listDemo {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,1.2345);

        List ll = new LinkedList();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        System.out.println("ll: " + ll);

        list.addAll(2, ll);
        list.addAll(ll);

        System.out.println(list);

        System.out.println(list.contains(1));
        System.out.println(list.contains("1"));
        System.out.println("containsAll:" + list.containsAll(ll));

//        List tt = List.copyOf(list);
//        System.out.println(tt);
//        tt.add(4);    // copyOf过来的，不可修改
//        System.out.println(tt);

//        System.out.println("equals:" + list.equals(tt));

//        System.out.println(tt.get(1));
//        System.out.println("(tt == list): " + (tt == list));
//        System.out.println("tt.hashcode: " + tt.hashCode());
        System.out.println("list.hashcode: " + list.hashCode());
        System.out.println("ll.hashcode: " + ll.hashCode());

        list.add("5");

        System.out.println("list.hashcode: " + list.hashCode());

        System.out.println("查找元素3的下标：" + list.indexOf(3));

        System.out.println("isEmpty: " + list.isEmpty());

        ListIterator iterator = list.listIterator();
        for (;iterator.hasNext(); ) {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
        System.out.println(list);
        System.out.println("previousIndex: " + iterator.previousIndex());
        System.out.println("previous value: " + iterator.previous());

        System.out.println("====listIterator index ===");
        ListIterator itIndex = list.listIterator(5);
        System.out.println("index: " + itIndex.nextIndex());
        System.out.println("value: " + itIndex.next());




        System.out.println("====set  size ===");
        list.set(3, "x");
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("=======sort=====");
//        list.sort((o1,o2)-> o1.hashCode() - o2.hashCode());
        System.out.println(list);

        System.out.println("=====sublist======");
        System.out.println(list.subList(3,5));  // 左闭右开 [3,5)

        System.out.println("=====toArray()");
        System.out.println(list.toArray().length);

        System.out.println("=======Retains =======");
        list.retainAll(ll);
        System.out.println("retainAll之后list：" + list);

        System.out.println("======remove====");
        System.out.println(list.remove(Integer.valueOf(2)));
        System.out.println(list);
        System.out.println(list.remove(3));
        System.out.println(list);
        list.removeAll(ll);
        System.out.println(list);
        list.clear();
        System.out.println("clear list: " + list);
    }

}
