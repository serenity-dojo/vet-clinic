package serenitylabs.tutorials.vetclinic.playingball.model;

public class Child {

    public void goPlay(Game game) {
        Player gameToPlay = gameCalled(game);
        gameToPlay.play();
    }

    private Player gameCalled(Game game) {
        switch (game) {
            case Football:
                return new PlayFootball();
            case Tennis:
                return new PlayTennis();
            case Cricket:
                return new PlayCricket();
            case Handball:
                return new PlayHandball();
            case Hockey:
                return new PlayHockey();
            default:
                throw new DontKnowThatGameException();
        }
    }

}
