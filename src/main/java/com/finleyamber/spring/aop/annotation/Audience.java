package com.finleyamber.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/4/10.
 */

@Aspect
public class Audience {
    @Pointcut("execution(* com.finleyamber.spring.aop.annotation.Performer.perform(..))")
    public void performance(){
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("The audience is taking seats");
    }
    @Before("performance()")
    public void turnOffCellphones(){
        System.out.println("The audience is turning off cellphone");
    }

    @AfterReturning("performance()")
    public void applaud(){
        System.out.println("The audience is applauding");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("The audicece demand for refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            long start = System.currentTimeMillis() ;
            joinPoint.proceed() ;
            long end = System.currentTimeMillis() ;
            System.out.println("Performance Cost :" +(end-start) + " mills");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
