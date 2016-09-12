package serenitylabs.tutorials.vetclinic.strategy.kata;


/**
 * Created by pravyada on 9/12/2016.
 */
public class PlayFootball implements PlayBall {
    @Override
    public Game play() {
        return Game.FOOTBOLL;
    }
}
