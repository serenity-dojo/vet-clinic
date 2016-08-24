package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayHandball implements PlayBall {
    @Override
    public Game play() {
        return Game.Handball;
    }
}
