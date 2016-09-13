package serenitylabs.tutorials.vetclinic.strategy.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static serenitylabs.tutorials.vetclinic.strategy.kata.SampleDates.*;

/**
 * Created by pravyada on 9/12/2016.
 */

@RunWith(Parameterized.class)
public class WhenSchedulingSchoolSports {
    private final LocalDate someDate;
    private final Game expectedGame;

    public WhenSchedulingSchoolSports(LocalDate someDate,Game expectedGame){
        this.someDate =someDate;
        this.expectedGame = expectedGame;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testdata() {
        return Arrays.asList(new Object[][] {
                { A_DATE_IN_JANUARY,    Game.TENNIS },
                { A_DATE_IN_MAY,        Game.TENNIS },
                { A_DATE_IN_JUNE,       Game.CRICKET },
                { A_DATE_IN_JULY,       Game.CRICKET },
                { A_DATE_IN_AUGUST,     Game.CRICKET },
                { A_DATE_IN_SEPTEMBER,  Game.CRICKET },
                { A_DATE_IN_OCTOBER,    Game.TENNIS },
                { A_DATE_IN_NOVEMBER,   Game.TENNIS },
        });
    }
    @Test
    public void should_play_tennis_in_winter_month_and_cricket_in_summer_month(){
    GameSchedule gameSchedule = new SchoolSportSchedule();
        assertThat(gameSchedule.forGameOn(someDate).play(),equalTo(expectedGame));
    }
}
