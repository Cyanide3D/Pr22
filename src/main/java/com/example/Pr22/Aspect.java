package com.example.Pr22;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @After("allServiceMethods()")
    public void logMethods(JoinPoint joinPoint) {
        log.info("Method " + joinPoint.getSignature().getName() + " end work...");
    }

    @Pointcut("within(com.example.Pr22.service.*)")
    public void allServiceMethods() {}

}
