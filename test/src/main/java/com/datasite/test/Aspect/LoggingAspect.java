package com.datasite.test.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut ("execution(* com.datasite.test.service.*.*(..))")
    public void service() {
    }

    @Before("service()")
    public void beforeCallingService(){
        log.info("Calling service method");
    }

    @After("service()")
    public void afterAdvice(){
        log.info("User service call completed Succesfully");
    }



}
