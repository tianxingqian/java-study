package com.mashibing.j2se.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class T005_dogs {

    public static void main(String[] args) {

        Dog dog1 = new Dog("大黄", "yellow");
        Dog dog2 = new Dog("二黄", "moon");
        Dog dog3 = new Dog("地黄", "tea");

        List list = new ArrayList();

        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        System.out.println(list);

        Dog dog4 = new Dog("地黄", "tea");
        System.out.println(list.contains(dog4));


    }



}

class Dog {
    private String name;
    private String color;

    public Dog(){}

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
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
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
        return Objects.hash(name, color);
    }
}
