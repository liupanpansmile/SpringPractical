package com.finleyamber.spring.aop.annotation;

import com.sun.org.glassfish.external.probe.provider.annotations.Probe;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2016/4/10.
 */
@Aspect
public class Magician implements MindReader {
    @Pointcut("execution(* com.finleyamber.spring.aop.annotation.Thinker.thinkOfSomething(String)) and args(thoughts)")
    public void thinking(String thoughts){

    }
    private String thoughts ;

    @Before("args(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Magician interceptThoughts");
        this.thoughts = thoughts ;
    }

    public String  getThoughts() {
        return thoughts ;
    }
}
