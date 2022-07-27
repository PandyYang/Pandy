package com.pandy.framework.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    /**
     * 定义的切点
     */
    @Pointcut("execution(* *.test(..))")
    public void test() {
    }

    /**
     * 前置通知
     */
    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest()...");
    }

    @After("test()")
    public void after() {
        System.out.println("afterTest()");
    }

    /**
     * 环绕通知
     */
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) throws Throwable {
        System.err.println("beforeTest by @Around");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable a) {
            a.printStackTrace();
        }
        System.err.println("afterTest by @Around...");
        return o;
    }

}
