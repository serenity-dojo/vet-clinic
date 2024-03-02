package serenitylabs.tutorials.vetclinic.playingball.model;
import java.time.LocalDate;
import java.time.Month;

public class SchoolSportsSchedule implements IGameSchedule {

	@Override
	public IPlayBall forGameOn(LocalDate someDay) {
	if ((someDay.getMonth() == Month.JUNE) || (someDay.getMonth() == Month.JULY) || 
		(someDay.getMonth() == Month.AUGUST) || (someDay.getMonth() == Month.SEPTEMBER)) 
	{
			return new PlayCricket();
	}
	return new PlayTennis();
	}

}