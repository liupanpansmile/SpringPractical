package com.finleyamber.spring.di.simple;

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

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }
}
