package com.chapter_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.chapter_1.service.impl.UserServiceImpl.*(..))")
    private void myPointCut(){

    }

    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知：模拟执行权限检查...，");
        System.out.print("目标类是：" + joinPoint.getTarget());
        System.out.println("，被植入增强处理的方法是：" + joinPoint.getSignature().getName());

    }

}
