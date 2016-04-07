package com.finleyamber.spring.di.simple;

/**
 * Created by Lpp on 2016/4/7.
 */
public class Actor implements Performer {

    private String movieName = "<Unkown>";
    private String actorName;

    public Actor() {

    }

    public Actor(String actorName, String movieName) {
        this.actorName = actorName;
        this.movieName = movieName;
    }

    public void perform() {
        System.out.println(actorName + " Acts a movie of " + movieName);
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
