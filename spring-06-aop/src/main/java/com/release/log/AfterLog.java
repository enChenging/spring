package com.release.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author yancheng
 * @since 2022/6/14
 */
public class AfterLog implements AfterReturningAdvice {

    //returnValue 执行后可以拿到返回值
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法，返回结果为："+returnValue);
    }
}
