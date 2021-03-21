package com.iday.pattern.singleton;

import java.util.concurrent.TimeUnit;

/*** 功能描述:  双重检查 单例
* @param:
* @return:
* @auther:
* @date:
*/
public class Singleton05 {

    private Singleton05(){}

    private static volatile Singleton05 instance = null;

    public static Singleton05 getInstance() {
        if (instance == null) {

            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(Singleton05.class) {
                if (instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }

}
