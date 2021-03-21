package com.iday.pattern.singleton;

import java.util.concurrent.TimeUnit;

/*** 功能描述:
 * @param:
 * @return:
 * @auther:
 * @date:
 */
public class Singleton04 {

    private Singleton04() {
    }

    private static volatile Singleton04 instance = null;

    public static Singleton04 getInstance() {
        if (instance == null) {

            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Singleton04.class) {
                instance = new Singleton04();
            }
        }
        return instance;
    }

}
