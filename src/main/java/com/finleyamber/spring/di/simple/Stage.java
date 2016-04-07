package com.finleyamber.spring.di.simple;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Stage {

    private Stage() {

    }

    public static class StageSingletonHolder {
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }
}
