package com.finleyamber.spring.di.annotationinject;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lpp on 2016/4/7.
 */
public class KnifeJuggler {
    private Set<Knife> knives ;

    @Inject
    public KnifeJuggler(Provider<Knife> knives) {
        System.out.println("KnifeJuggler Constructor");
        this.knives = new HashSet<Knife>() ;
        for(int i =0 ;i <5 ;++i){
            this.knives.add(knives.get()) ;
        }
    }

    public Set<Knife> getKnives() {
        return knives;
    }


    public void setKnives(Set<Knife> knives) {
        this.knives = knives;
    }
}
