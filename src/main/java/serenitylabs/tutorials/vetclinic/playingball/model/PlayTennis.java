package serenitylabs.tutorials.vetclinic.playingball.model;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/31/16
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlayTennis implements PlayBall {
    @Override
    public Game play() {
        return Game.Tennis;
    }
}
