package com.finleyamber.spring.aop.annotation;

/**
 * Created by Administrator on 2016/4/10.
 */
public class Volunteer implements Thinker {
    private String thoughts ;
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts ;
    }
    public String getThoughts(){
        return thoughts ;
    }
}
