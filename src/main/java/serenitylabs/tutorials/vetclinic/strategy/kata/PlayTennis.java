package serenitylabs.tutorials.vetclinic.strategy.kata;

/**
 * Created by pravyada on 9/13/2016.
 */
public class PlayTennis implements PlayBall {
    @Override
    public Game play() {
        return Game.TENNIS;
    }
}
