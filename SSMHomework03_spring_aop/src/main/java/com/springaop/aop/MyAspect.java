package com.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.springaop.service.impl.AopServiceImpl.*(..))")
    private void myPointCut(){

    }

    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("AspectJ before method is invoking...");
    }

    @After("myPointCut()")
    public void myAfter(JoinPoint joinPoint){
        System.out.println("AspectJ after method is invoking...");
    }


    @AfterThrowing(value = "myPointCut()", throwing = "throwable")
    @Transactional(propagation= Propagation.REQUIRED)
    public void myAfterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("Exception is happened..." + throwable.getMessage());
    }

}
