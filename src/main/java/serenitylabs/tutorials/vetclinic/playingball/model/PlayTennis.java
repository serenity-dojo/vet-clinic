package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayTennis implements PlayBall {
    @Override
    public Game play() {
        return Game.Tennis;
    }
}
