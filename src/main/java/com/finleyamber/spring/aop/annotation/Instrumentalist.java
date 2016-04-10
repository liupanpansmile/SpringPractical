package com.finleyamber.spring.aop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    @Autowired
    @Value("Rose")
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

    public void perform() throws Exception {
        System.out.print("Playing " + song + ":");
        instrument.play();
        //throw new Exception("表演失败") ;
    }
}
