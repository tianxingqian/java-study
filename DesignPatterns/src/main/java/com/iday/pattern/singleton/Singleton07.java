package com.iday.pattern.singleton;

import java.util.Date;

/*** 功能描述:  双重检查 单例
* @param:
* @return:
* @auther:
* @date:
*/
public enum  Singleton07 {

    INSTANCE;

    private Date d;

    private Singleton07(){
        d = new Date();
        System.out.println("构造了");
    }

    public Date buildDate() {
        return d;
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Singleton07.INSTANCE.buildDate().hashCode());
            }).start();
        }
    }
}
