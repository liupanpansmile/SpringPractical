package com.finleyamber.spring.di.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/resource/ApplicationContext.xml") ;

        Instrumentalist instrumentalist = (Instrumentalist) context.getBean("instrumentalist") ;
        instrumentalist.perform();
    }
}
