package serenitylabs.tutorials.vetclinic.playingball.model;
import java.time.LocalDate;
import static java.time.DayOfWeek.*;

public class RecreationalSportsSchedule implements IGameSchedule {

	@Override
	public IPlayBall forGameOn(LocalDate someDay) {
		if ((someDay.getDayOfWeek() == SATURDAY) || (someDay.getDayOfWeek() == SUNDAY)) {
		return new PlayFootball();
		}
	return new PlayHandball();
	}

}