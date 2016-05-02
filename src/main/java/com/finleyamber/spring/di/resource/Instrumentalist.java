package com.finleyamber.spring.di.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//import javax.annotation.Resource ;
/**
 * Created by Lpp on 2016/4/7.
 */
@Component
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

    
    //@Autowired //byType Inject
    @Resource(name="piano")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() {
        System.out.print("Playing " + song + ":");
        instrument.play();
    }
}
