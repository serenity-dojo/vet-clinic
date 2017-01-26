package serenitylabs.tutorials.vetclinic.playingball;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.SchoolSportsSchedule;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;
import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Parameterized.class)
//@RunWith(JUnitParamsRunner.class)
public class WhenSchedulingSchoolSportByVikrant {


    private GameSchedule schoolSportScheduler;
    private final LocalDate localDate;
    private final Game game;

    public WhenSchedulingSchoolSportByVikrant(LocalDate localDate, Game game) {
        this.localDate = localDate;
        this.game = game;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {A_DATE_IN_JANUARY, Tennis},
                {A_DATE_IN_FEBRUARY, Tennis},
                {A_DATE_IN_MARCH, Tennis},
                {A_DATE_IN_APRIL, Tennis},
                {A_DATE_IN_MAY, Tennis},
                {A_DATE_IN_JUNE, Cricket},
                {A_DATE_IN_JULY, Cricket},
                {A_DATE_IN_AUGUST, Cricket},
                {A_DATE_IN_SEPTEMBER, Cricket},
                {A_DATE_IN_OCTOBER, Tennis},
                {A_DATE_IN_NOVEMBER, Tennis},
                {A_DATE_IN_DECEMBER, Tennis},
        });
    }

    @Before
    public void setup() {
        schoolSportScheduler = new SchoolSportsSchedule();
    }

    @Test
    public void should_play_cricket_in_the_summer_months_and_tennis_in_winter_months() throws Exception {
        assertThat(schoolSportScheduler.forGameOn(localDate).play(), equalTo(game));
    }

}
