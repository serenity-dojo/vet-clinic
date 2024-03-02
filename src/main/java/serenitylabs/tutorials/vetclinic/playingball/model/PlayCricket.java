package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayCricket implements IPlayer, IPlayBall {

	public void play() {
		System.out.print("Hit the wicket");
	}

	public GameEnum letEnumToPlay() {
		return GameEnum.Cricket;
	}

}