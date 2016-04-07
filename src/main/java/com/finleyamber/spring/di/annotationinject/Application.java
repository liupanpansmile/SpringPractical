package com.finleyamber.spring.di.annotationinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/annotationinject/ApplicationContext.xml") ;

        Instrumentalist instrumentalist = (Instrumentalist) context.getBean("instrumentalist") ;
        instrumentalist.perform();

        KnifeJuggler knifeJuggler = (KnifeJuggler)context.getBean("knifeJuggler") ;

        /*调用一下代码时，knifeJuggler才会被注入*/
        Set<Knife> knives =  knifeJuggler.getKnives() ;
        for (Knife knife:knives){
            System.out.println(knife.getName() + " " + knife);
        }
    }
}
