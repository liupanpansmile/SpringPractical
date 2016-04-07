package com.finleyamber.spring.di.annotationautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Instrumentalist implements Performer {

    private String song ;
    private Instrument instrument ;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    //通过使用byType 自动注入
    @Autowired
    //@Qualifier("guitar")  //可以指定查找bean名称为guitar注入
    @StringedInstrument   //缩小注入范围：管弦乐
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }
}
