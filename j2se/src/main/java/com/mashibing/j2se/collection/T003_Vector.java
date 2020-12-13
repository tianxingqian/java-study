package com.mashibing.j2se.collection;

import java.util.Vector;

public class T003_Vector {


    public static void main(String[] args) {
        Vector vector = new Vector();

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("a");
        vector.add("b");
        vector.add("c");

        System.out.println(vector);
    }

}
