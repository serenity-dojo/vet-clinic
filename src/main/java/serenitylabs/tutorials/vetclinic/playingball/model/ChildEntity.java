package serenitylabs.tutorials.vetclinic.playingball.model;
import java.time.LocalDate;

public class ChildEntity {

	public static ChildEntity childEntity;
	private final SportsSchedule sportsSchedule;

	private ChildEntity() {
		this.sportsSchedule = new SportsSchedule();
	}

	/**
	 * @param childEntity the childEntity to set
	 */
	public static synchronized ChildEntity getChildEntity() {
		if (childEntity == null) {
			childEntity = new ChildEntity();
		}
		return childEntity;
	}

	public ChildEntity(SportsSchedule sportsSchedule) {
		this.sportsSchedule = sportsSchedule;
	}

	public void goPlay(GameEnum game) {
		IPlayer gameToPlay = PlayerForGame.called(game);
		gameToPlay.play();
	}

	public GameEnum goPlayBallOn(LocalDate someDay) {
		return sportsSchedule.forDate(someDay).letEnumToPlay();
	}

}