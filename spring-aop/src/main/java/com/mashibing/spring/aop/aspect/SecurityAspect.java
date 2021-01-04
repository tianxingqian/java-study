package com.mashibing.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
//@Component
//@Order(1)
public class SecurityAspect implements Ordered {

    @Pointcut("execution(* *.* (..))")
    public void pointcut2() {}

    @Before("pointcut2()")
    public void start(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@Before方法：" + joinPoint.getSignature().getName() + "，参数：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointcut2()")
    public void after(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@After");
    }

    @AfterReturning("pointcut2()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@AfterReturning");
    }

    @AfterThrowing("pointcut2()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("SecurityAspect---@AfterThrowing");
    }

    @Around("pointcut2()")
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

    @Override
    public int getOrder() {
        return 1;
    }
}
