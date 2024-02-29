package serenitylabs.tutorials.vetclinic.playingball.model;

public class PlayerForGame {

	public static IPlayer called(GameEnum game) {
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
			throw new DontKnowThatGameException("Wrong!! choice..");
		}
	}

}
