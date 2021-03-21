package com.iday.pattern.singleton;

public class Singleton03 {

    private Singleton03(){}

    private static Singleton03 instance = null;

    public static synchronized Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }

}
