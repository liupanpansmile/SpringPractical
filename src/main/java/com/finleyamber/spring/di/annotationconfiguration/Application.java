package com.finleyamber.spring.di.annotationconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/annotationconfiguration/ApplicationContext.xml") ;

        Instrumentalist instrumentalist = (Instrumentalist) context.getBean("instrumentalist") ;
        instrumentalist.perform();
    }
}
