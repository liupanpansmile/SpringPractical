package com.finleyamber.spring.aop.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/aop/simple/ApplicationContext.xml") ;

        Performer performer = (Performer) context.getBean("instrumentalist") ;
        MindReader magician = (MindReader) context.getBean("magician") ;
        Thinker volunteer = (Thinker) context.getBean("volunteer") ;
        try {
            performer.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String msg ="aaa" ;
        volunteer.thinkOfSomething(msg);
        String thoughts = magician.getThoughts() ;
        System.out.println(thoughts);
    }
}
