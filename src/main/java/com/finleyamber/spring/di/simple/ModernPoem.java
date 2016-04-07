package com.finleyamber.spring.di.simple;

/**
 * Created by Lpp on 2016/4/7.
 */
public class ModernPoem implements Poem {
    private final String CONTENT = "窗前明月灯光，疑似地上霜" ;

    public void recite() {
        System.out.println(CONTENT);
    }
}
