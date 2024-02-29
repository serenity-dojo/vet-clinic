package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayTennis implements IPlayer,IPlayBall {

	@Override
	public void play() {
		System.out.print("Serve the ball");
	}

	@Override
	public GameEnum letEnumToPlay() {
		return GameEnum.Tennis;
	}

}