package com.kk.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2019/7/17 12:02
 * @Description:
 */
@Component
@Aspect
public class AopConfig {

    @Pointcut(value = "execution(* com.kk.pojo.*.* (..))")
    public void point(){

    }

    @Before(value = "point()")
    public void before(){
        System.out.println("before");
    }

    @After(value = "point()")
    public void after(){
        System.out.println("after");
    }

}
