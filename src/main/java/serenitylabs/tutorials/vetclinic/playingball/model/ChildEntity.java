package serenitylabs.tutorials.vetclinic.playingball.model;

public class ChildEntity {

	public void goPlay(GameEnum game) {
		IPlayer gameToPlay = PlayerForGame.called(game);
		gameToPlay.play();
	}

}
