package com.mashibing.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class SecurityAspect2 {

    public void start(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@Before方法：" + joinPoint.getSignature().getName() + "，参数：" + Arrays.asList(joinPoint.getArgs()));
    }


    public void after(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@After");
    }


    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@AfterReturning");
    }


    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@AfterThrowing");
    }


    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("SecurityAspect---@around");
        Object result = null;
        try {
            System.out.println("SecurityAspect---环绕开始");
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            System.out.println("SecurityAspect---环绕返回");
        } catch (Throwable e) {
            System.out.println("SecurityAspect---环绕-异常 ");
        } finally {
            System.out.println("SecurityAspect---环绕finally ");
        }
        return result;

    }
}
