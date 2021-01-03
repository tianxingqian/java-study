package com.mashibing.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object rs = null;
        try {
            System.out.println(method.getName() + " 开始执行， 参数：" + Arrays.asList(args));
            rs = method.invoke(obj, args);
            System.out.println(method.getName() + " 执行完成");
        } catch (Exception e) {
            System.out.println("方法异常");
            throw e;
        } finally {
            System.out.println("方法执行结束");
        }
        return rs;
    }
}
