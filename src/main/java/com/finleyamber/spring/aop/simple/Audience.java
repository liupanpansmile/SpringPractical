package com.finleyamber.spring.aop.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/4/10.
 */

@Component
public class Audience {

    public void takeSeats(){
        System.out.println("The audience is taking seats");
    }
    public void turnOffCellphones(){
        System.out.println("The audience is turning off cellphone");
    }

    public void applaud(){
        System.out.println("The audience is applauding");
    }

    public void demandRefund(){
        System.out.println("The audicece demand for refund");
    }

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
