package com.finleyamber.spring.aop.annotation;


/**
 * Created by Lpp on 2016/4/7.
 */
@StringedInstrument
public class Guitar implements Instrument {

    public void play() {
        System.out.println("Rock Rock...");
    }
}
