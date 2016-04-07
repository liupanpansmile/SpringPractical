package com.finleyamber.spring.di.annotationinject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lpp on 2016/4/7.
 */

public class Provider<T> {
    private ArrayList<T> list = new ArrayList<T>();
    private int currentIndex = 0;
    public T get(){
        System.out.println("get called currentIndex: " + currentIndex);
        if(currentIndex >= list.size()){
            currentIndex = 0 ;
        }
        return list.get(currentIndex++);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(List<T> list) {

        for (T t:list){
            this.list.add(t) ;
        }
    }
}
