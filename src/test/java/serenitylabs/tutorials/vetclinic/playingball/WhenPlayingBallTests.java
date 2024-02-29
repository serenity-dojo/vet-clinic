package serenitylabs.tutorials.vetclinic.playingball;
import static java.time.Month.AUGUST;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.time.LocalDate;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.ChildEntity;
import serenitylabs.tutorials.vetclinic.playingball.model.GameEnum;
import serenitylabs.tutorials.vetclinic.playingball.model.SportsSchedule;

public class WhenPlayingBallTests {

	static final LocalDate A_SATURDAY = LocalDate.of(2016, AUGUST, 27);
	static final LocalDate A_SUNDAY = LocalDate.of(2016, AUGUST, 28);
	static final LocalDate A_MONDAY = LocalDate.of(2016, AUGUST, 29);

	@Test
	public void should_play_football_on_sundays() {

		SportsSchedule sportsSchedule = new SportsSchedule();
		ChildEntity bill = new ChildEntity(sportsSchedule);

		GameEnum gamePlayed = bill.goPlayBallOn(A_SUNDAY);

		assertThat(gamePlayed, equalTo(GameEnum.Football));
	System.out.println("\nTC-01 - Executing - should_play_football_on_sundays()");
	}

	
	@Test
	public void should_play_football_on_saturdays() {
		SportsSchedule sportsSchedule = new SportsSchedule();
		ChildEntity bill = new ChildEntity(sportsSchedule);

		GameEnum gamePlayed = bill.goPlayBallOn(A_SATURDAY);

		assertThat(gamePlayed, equalTo(GameEnum.Football));
	System.out.println("\nTC-02 - Executing - should_play_football_on_saturdays()");
	}

	
	@Test
	public void should_play_handball_on_weekdays() {
		SportsSchedule sportsSchedule = new SportsSchedule();
		ChildEntity bill = new ChildEntity(sportsSchedule);

		GameEnum gamePlayed = bill.goPlayBallOn(A_MONDAY);

		assertThat(gamePlayed, equalTo(GameEnum.Handball));
	System.out.println("\nTC-03 - Executing - should_play_handball_on_weekdays()");
	}

	
	@Test
	public void should_play_tennis_on_wednesdays() {
		SportsSchedule sportsSchedule = new SportsSchedule();
		ChildEntity bill = new ChildEntity(sportsSchedule);

		GameEnum gamePlayed = bill.goPlayBallOn(A_MONDAY);

		assertThat(gamePlayed, equalTo(GameEnum.Handball));
	System.out.println("\nTC-04 - Executing - should_play_tennis_on_wednesdays()");
	}

}