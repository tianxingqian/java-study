package com.mashibing.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public int com.mashibing.spring.aop.service.MyCalculate.add(int, int))")
    public void pointcut() {}

    @Pointcut("execution(* *.* (..))")
    public void pointcut2() {}

    @Before(value = "pointcut2()")
    public void start(JoinPoint joinPoint) {
        System.out.println("@Before方法：" + joinPoint.getSignature().getName() + "，参数：" + Arrays.asList(joinPoint.getArgs()));
    }

    // finally
    @After(value = "pointcut2()")
    public void after(JoinPoint joinPoint) {
        System.out.println("@After");
    }

    @AfterReturning("pointcut2()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing("pointcut2()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("@AfterThrowing");
    }

    @Around("pointcut2()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("@around");
        Object result = null;
        try {
            System.out.println("环绕开始");
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            System.out.println("环绕结束");
        } catch (Throwable e) {
            System.out.println("环绕-异常");
        } finally {
            System.out.println("环绕返回通知");
        }

        return result;

    }

}
