package com.finleyamber.spring.di.annotationautowire;


/**
 * Created by Lpp on 2016/4/7.
 */
@StringedInstrument
public class Guitar implements Instrument {

    public void play() {
        System.out.println("Rock Rock...");
    }
}
