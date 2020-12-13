package com.mashibing.j2se.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class T007_map {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put(new Dog("a", "red"), 1);
        map.put(new Dog("b", "red"), 2);
        map.put(new Dog("c", "d"), 3);
        map.put(new Dog("d", "d"), 4);
        map.put(new Dog("e", "f"), 5);
        map.put(new Dog("f", "s"), 6);
        map.put(new Dog("g", "b"), 7);
        map.put(new Dog("h", "b"), 8);
        map.put(new Dog("i", "b"), 9);
        map.put(new Dog("j", "g"), 10);
        map.put(new Dog("k", "g"), 11);
        map.put(new Dog("l", "g"), 12);
        map.put(new Dog("m", "t"), 13);
        map.put(new Dog("n", "e"), 14);

        System.out.println(map);

    }

    static class Dog {
        private String name;
        private String color;

        public Dog(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return Objects.equals(name, dog.name) &&
                    Objects.equals(color, dog.color);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
