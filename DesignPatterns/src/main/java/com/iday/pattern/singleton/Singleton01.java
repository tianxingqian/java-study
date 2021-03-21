package com.iday.pattern.singleton;

public class Singleton01 {

    private Singleton01(){}

    private static Singleton01 singleton01 = new Singleton01();

    public static Singleton01 getInstance(){
        return singleton01;
    }


}
