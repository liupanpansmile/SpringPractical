package com.finleyamber.spring.di.spel;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.OpDec;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/spel/ApplicationContext.xml");

        City city = (City) context.getBean("city");
        System.out.println(city);

        List<City> cities = (List<City>) context.getBean("cities");
        for (City c : cities) {
            System.out.println(c);
        }

        ChosenCity chosenCity = (ChosenCity) context.getBean("chosenCity");
        System.out.println(chosenCity.getCity());


        //properties
        Properties props = (Properties) context.getBean("dbproperties");
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }


        Order order = (Order) context.getBean("order") ;
        System.out.println(order.getId() +  " " +  order.getCustomerId() + " " + order.getName() );
    }
}
