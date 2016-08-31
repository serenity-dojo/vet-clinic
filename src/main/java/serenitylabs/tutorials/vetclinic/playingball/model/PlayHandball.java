package serenitylabs.tutorials.vetclinic.playingball.model;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayHandball implements PlayBall {
    @Override
    public Game play() {
        return Game.Handball;
    }
}
