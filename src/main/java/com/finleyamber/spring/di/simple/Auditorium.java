package com.finleyamber.spring.di.simple;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Auditorium implements InitializingBean,DisposableBean{

    public void destroy() throws Exception {
        System.out.println("destroy Auditorium");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("init Auditorium");
    }

    public void turnOnLights(){
        System.out.println("Turn On Lights");
    }

    public void turnOffLights(){
        System.out.println("Turn Off Lights");
    }
}
