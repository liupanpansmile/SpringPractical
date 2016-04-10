package com.finleyamber.spring.aop.simple;

/**
 * Created by Administrator on 2016/4/10.
 */
public class Magician implements MindReader {
    private String thoughts ;
    public void interceptThoughts(String thoughts) {
        System.out.println("Magician interceptThoughts");
        this.thoughts = thoughts ;
    }

    public String  getThoughts() {
        return thoughts ;
    }
}
