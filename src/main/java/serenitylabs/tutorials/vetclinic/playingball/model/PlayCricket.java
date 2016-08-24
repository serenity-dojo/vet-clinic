package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayCricket implements PlayBall {
    @Override
    public Game play() {
        return Game.Cricket;
    }
}
