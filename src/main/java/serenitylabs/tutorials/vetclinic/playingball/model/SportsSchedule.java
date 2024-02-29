package serenitylabs.tutorials.vetclinic.playingball.model;
import java.time.LocalDate;
import static java.time.DayOfWeek.WEDNESDAY;

public class SportsSchedule {

	IGameSchedule schoolSportScheduled = new SchoolSportsSchedule();
	IGameSchedule recreationalSportScheduled = new RecreationalSportsSchedule();

	public IPlayBall forDate(LocalDate currentDay) {
		if (currentDay.getDayOfWeek() == WEDNESDAY) {
			return schoolSportScheduled.forGameOn(currentDay);
		} else {
			return recreationalSportScheduled.forGameOn(currentDay);
		}
	}

}