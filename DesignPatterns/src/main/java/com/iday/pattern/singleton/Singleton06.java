package com.iday.pattern.singleton;

/*** 功能描述:  双重检查 单例
* @param:
* @return:
* @auther:
* @date:
*/
public class Singleton06 {

    private Singleton06(){}

    private static class InnerHolder {
        private static volatile Singleton06 instance = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return InnerHolder.instance;
    }

}
