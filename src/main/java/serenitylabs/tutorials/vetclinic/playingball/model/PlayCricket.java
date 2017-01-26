package serenitylabs.tutorials.vetclinic.playingball.model;

/**
 * Created by kimahale on 9/8/2016.
 */
public class PlayCricket implements PlayBall {
    @Override
    public Game play() {
        return Game.Cricket;
    }
}
