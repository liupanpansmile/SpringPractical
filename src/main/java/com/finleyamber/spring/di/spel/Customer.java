package com.finleyamber.spring.di.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Author: Finley Amber
 * DateTime  : 2016/5/2.13:31
 * Description :
 */

@Component
public class Customer {
    private long id ;
    private String name ;

    public long getId() {
        return id;
    }

    @Inject
    @Value("#{customerproperties.customer_id}")
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Inject
    @Value("#{customerproperties.customer_name}")
    public void setName(String name) {
        this.name = name;
    }
}
