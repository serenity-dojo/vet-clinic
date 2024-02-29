package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayFootball implements IPlayer,IPlayBall {

	@Override
	public void play() {
		System.out.print("Kick the ball");
	}

	public GameEnum letEnumToPlay() {
	return GameEnum.Football;
	}

}