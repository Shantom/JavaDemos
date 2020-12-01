package com.shantom.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoPointCut {

    @Before("execution(* com.shantom.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("before(anno)");
    }

    @After("execution(* com.shantom.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("after(anno)");
    }

}
