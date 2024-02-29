package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayHockey implements IPlayer,IPlayBall {

	@Override
	public void play() {
		System.out.print("Hit the ball with the stick");
	}

	@Override
	public GameEnum letEnumToPlay() {
		return GameEnum.Hockey;
	}

}