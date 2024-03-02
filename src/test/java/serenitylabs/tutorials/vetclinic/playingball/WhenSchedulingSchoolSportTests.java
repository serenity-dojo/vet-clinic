package serenitylabs.tutorials.vetclinic.playingball;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_AUGUST;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_JANUARY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_JULY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_JUNE;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_MAY;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_NOVEMBER;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_OCTOBER;
import static serenitylabs.tutorials.vetclinic.playingball.model.SampleDates.A_DATE_IN_SEPTEMBER;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.playingball.model.GameEnum;
import serenitylabs.tutorials.vetclinic.playingball.model.IGameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.SchoolSportsSchedule;

@RunWith(Parameterized.class)
public class WhenSchedulingSchoolSportTests {

	private final LocalDate someDate;
	private final GameEnum expectedGame;

	@Parameterized.Parameters
	public static Collection<Object[]> testdata() {
		return Arrays.asList(new Object[][] 
		{ 
			{ A_DATE_IN_JANUARY, GameEnum.Tennis }, 
			{ A_DATE_IN_MAY, GameEnum.Tennis },
			{ A_DATE_IN_JUNE, GameEnum.Cricket }, 
			{ A_DATE_IN_JULY, GameEnum.Cricket }, 
			{ A_DATE_IN_AUGUST, GameEnum.Cricket },
			{ A_DATE_IN_SEPTEMBER, GameEnum.Cricket }, 
			{ A_DATE_IN_OCTOBER, GameEnum.Tennis },
			{ A_DATE_IN_NOVEMBER, GameEnum.Tennis }, 
		});
		}

	public WhenSchedulingSchoolSportTests(LocalDate someDate, GameEnum expectedGame) {
	        this.someDate = someDate;
	        this.expectedGame = expectedGame;
	}

	@Test
	public void should_play_cricket_in_the_summer_months_and_tennis_in_winter_months() {
		IGameSchedule schoolSports = new SchoolSportsSchedule();

		assertThat(schoolSports.forGameOn(someDate).letEnumToPlay(), equalTo(expectedGame));
	System.out.println("\nTC-01 - Executing - should_play_cricket_in_the_summer_months_and_tennis_in_winter_months()");
	}
}