package com.finleyamber.spring.di.scope;

import com.finleyamber.spring.di.annotationautowire.Instrumentalist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* Bean 作用域
* singleton :在每一个context中，一个bean只有一个实例对象（默认）
* prototype :每次调用都会创建一个新的实例
* */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/finleyamber/spring/di/scope/ApplicationContext.xml") ;

        Person p1  = (Person) context.getBean("person") ;
        p1.setId(1);
        p1.setName("jack");
        p1.setAge(24);

        Person p2  = (Person) context.getBean("person") ;

        System.out.println(p1 == p2);                   //true
        System.out.println(p2.getId() + p2.getName());  //1jack

    }
}
