package com.finleyamber.spring.di.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/simple/ApplicationContext.xml") ;
        Actor actor = (Actor) context.getBean("actor") ;
        actor.setActorName("LiangChaowei");
        actor.perform();
        Actor actor2 = (Actor) context.getBean("actor") ;
        System.out.println(actor==actor2);


        ActorPoem actorPoem = (ActorPoem) context.getBean("actorPoem") ;
        actorPoem.perform();


        //Auditorium auditorium =(Auditorium) context.getBean("auditorium") ;

        Instrumentalist instrumentalist = (Instrumentalist) context.getBean("instrumentalist") ;
        instrumentalist.perform();

    }
}
