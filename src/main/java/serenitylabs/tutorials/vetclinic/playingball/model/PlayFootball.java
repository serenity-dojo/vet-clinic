package serenitylabs.tutorials.vetclinic.playingball.model;

/**
 * Created by siddharthk on 9/6/2016.
 */
public class PlayFootball implements PlayBall {
    @Override
    public Game play() {
        return Game.Football;
    }
}
