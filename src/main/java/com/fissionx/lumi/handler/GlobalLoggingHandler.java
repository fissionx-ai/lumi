package com.fissionx.lumi.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalLoggingHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalLoggingHandler.class);

    @Pointcut("execution(* com.fissionx.lumi.controller..*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method '{}' started", methodName);
    }

    @After("controllerMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method '{}' execution finished", methodName);
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method '{}' executed successfully, returned value: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint,Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Method '{}' execution failed with exception: ", methodName, exception);
    }
}
