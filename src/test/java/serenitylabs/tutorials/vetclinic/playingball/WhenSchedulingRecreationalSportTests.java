package serenitylabs.tutorials.vetclinic.playingball;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_FRIDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_MONDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_SATURDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_SUNDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_THURSDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_TUESDAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_WEDNESDAY;
import java.time.LocalDate;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.Lists;
import serenitylabs.tutorials.vetclinic.playingball.model.GameEnum;
import serenitylabs.tutorials.vetclinic.playingball.model.IGameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.RecreationalSportsSchedule;

public class WhenSchedulingRecreationalSportTests {

	IGameSchedule scheduler;
	static final List<LocalDate> WEEKEND_DAYS = Lists.newArrayList(A_SATURDAY, A_SUNDAY);
	static final List<LocalDate> WEEK_DAYS = Lists.newArrayList(A_MONDAY, A_TUESDAY, A_WEDNESDAY, A_THURSDAY, A_FRIDAY);

	@BeforeTest
	public void setup() {
		scheduler = new RecreationalSportsSchedule();
		System.out.println("\nExecuting TC-01 - setup()");
	}

	
	@Test
	public void should_play_football_on_the_weekends() {
		WEEKEND_DAYS.forEach(day -> assertThat(scheduler.forGameOn(day).letEnumToPlay(), equalTo(GameEnum.Football)));
	System.out.println("\nExecuting TC-02 - should_play_football_on_the_weekends() ");
	}

	
	@Test
	public void should_play_handball_during_the_week() {
		WEEK_DAYS.forEach(day -> assertThat(scheduler.forGameOn(day).letEnumToPlay(), equalTo(GameEnum.Handball)));
	System.out.println("\nExecuting TC-03 - should_play_handball_during_the_week() ");
	}

}