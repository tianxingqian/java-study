package com.mashibing.spring.aop.proxy;

import com.mashibing.spring.aop.service.Calculate;

import java.lang.reflect.Proxy;

public class MyProxy {

    public Calculate getProxy(Calculate obj) {

        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new MyInvocationHandler(obj));
        return (Calculate) proxy;
    }

}
