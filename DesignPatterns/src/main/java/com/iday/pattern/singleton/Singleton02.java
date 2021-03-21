package com.iday.pattern.singleton;

public class Singleton02 {

    private Singleton02(){}

    private static Singleton02 instance = null;

    public static Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }

}
