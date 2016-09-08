package serenitylabs.tutorials.vetclinic.playingball;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.SchoolSportsSchedule;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.A_DATE_IN_NOVEMBER;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.Tennis;

/**
 * Created by siddharthk on 9/6/2016.
 */
@RunWith(Parameterized.class)
public class WhenSchedulingSchoolSports {

    private GameSchedule schedule;
    private LocalDate date;
    private Game game;

    @Before
    public void setUp() throws Exception {
        schedule = new SchoolSportsSchedule();

    }

    public WhenSchedulingSchoolSports(LocalDate date, Game game) {
        this.date = date;
        this.game = game;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> winterTestData() {
        return Arrays.asList(new Object[][] {
                { A_DATE_IN_SEPTEMBER,  Game.Tennis },
                { A_DATE_IN_OCTOBER,    Game.Tennis },
                { A_DATE_IN_NOVEMBER,   Game.Tennis },
                { A_DATE_IN_NOVEMBER, Game.Tennis}
        });
    }

    @Test
    public void should_play_tennis_in_winter() throws Exception {

        MatcherAssert.assertThat(schedule.forGameOn(date).play(),equalTo(game));
    }

}
