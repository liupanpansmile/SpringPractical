package com.finleyamber.spring.di.scope;

import org.springframework.stereotype.Component;

/**
 * Author: Finley Amber
 * Date  : 2016/5/2.
 * Time  : 12:26
 * Description :
 */

@Component
public class Person {
    private int id ;
    private String name ;
    private int age ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
