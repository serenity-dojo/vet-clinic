package serenitylabs.tutorials.vetclinic.playingball.model;

public class Child {
    public void goPlay(Game game) {
        Player gameToPlay = PlayerForGame.called(game);
        gameToPlay.play();
    }
}
