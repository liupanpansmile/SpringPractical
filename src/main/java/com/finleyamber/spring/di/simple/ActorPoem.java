package com.finleyamber.spring.di.simple;

/**
 * Created by Lpp on 2016/4/7.
 */
public class ActorPoem extends Actor {
    private Poem poem;

    public ActorPoem(String actorName,String movieName, Poem poem) {
        super(actorName,movieName);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        poem.recite();
    }
}
