package com.finleyamber.spring.di.annotationinject;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Knife {
    @Value("#{properties.knifename}")
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
