package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayHandball implements IPlayer,IPlayBall {

	@Override
	public void play() {
		System.out.print("Throw the ball");
	}

	@Override
	public GameEnum letEnumToPlay() {
		return GameEnum.Handball;
	}

}
