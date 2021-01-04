package com.mashibing.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LogAspect2 {


    public void start(JoinPoint joinPoint) {
        System.out.println("@Before方法：" + joinPoint.getSignature().getName() + "，参数：" + Arrays.asList(joinPoint.getArgs()));
    }


    public void after(JoinPoint joinPoint) {
        System.out.println("@After");
    }


    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("@AfterReturning");
    }


    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("@AfterThrowing");
    }


    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("@around");
        Object result = null;
        try {
            System.out.println("环绕开始");
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            System.out.println("环绕返回");
        } catch (Throwable e) {
            System.out.println("环绕-异常 ");
        } finally {
            System.out.println("环绕finally ");
        }
        return result;

    }

}
