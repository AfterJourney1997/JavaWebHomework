package com.springaop.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspectByProxy implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object object = methodInvocation.proceed();
        after();
        return object;
    }

    private void after(){
        System.out.println("MyAspectByProxy after method is invoking...");
    }

    private void before(){
        System.out.println("MyAspectByProxy before method is invoking...");
    }
}
