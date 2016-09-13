package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.SchoolSportsSchedule;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

@RunWith(Parameterized.class)
public class WhenSchedulingSchoolSport {

    private final LocalDate someDate;
    private final Game expectedGame;

    @Parameterized.Parameters
    public static Collection<Object[]> testdata() {
        return Arrays.asList(new Object[][] {
                { A_DATE_IN_JANUARY,    Game.Tennis },
                { A_DATE_IN_MAY,        Game.Tennis },
                { A_DATE_IN_JUNE,       Game.Cricket },
                { A_DATE_IN_JULY,       Game.Cricket },
                { A_DATE_IN_AUGUST,     Game.Cricket },
                { A_DATE_IN_SEPTEMBER,  Game.Cricket },
                { A_DATE_IN_OCTOBER,    Game.Tennis },
                { A_DATE_IN_NOVEMBER,   Game.Tennis },
        });
    }

    public WhenSchedulingSchoolSport(LocalDate someDate, Game expectedGame) {
        this.someDate = someDate;
        this.expectedGame = expectedGame;
    }


    @Test
    public void should_play_cricket_in_the_summer_months_and_tennis_in_winter_months() {
        GameSchedule schoolSports = new SchoolSportsSchedule();

        assertThat(schoolSports.forGameOn(someDate).play(), equalTo(expectedGame));
    }

}
