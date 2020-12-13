package com.mashibing.j2se.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class T004_iterator {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer i = it.next();
            if (i == 3) it.remove();
        }

        for (ListIterator<Integer> it=list.listIterator(); it.hasNext(); ) {
            Integer i = it.next();
            if (i == 4) {
                it.remove();    // 删除5
                it.add(10);     // 添加10
                it.add(10);     // 添加10
//                it.set(9);
            }
        }

        for (Integer i : list) {
            System.out.println(i);
        }

    }
}
