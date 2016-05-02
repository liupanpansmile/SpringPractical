package com.finleyamber.spring.di.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Author: Finley Amber
 * DateTime  : 2016/5/2 13:33
 * Description :
 */

@Component
public class Order {
    private int id ;
    private int customerId ;
    private String name ;

    public int getId() {
        return id;
    }

    @Inject
    @Value("#{customerproperties.order_id}")
    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Inject
    @Value("#{customerproperties.customer_id}")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    @Inject
    @Value("#{customerproperties.order_name}")
    public void setName(String name) {
        this.name = name;
    }
}
