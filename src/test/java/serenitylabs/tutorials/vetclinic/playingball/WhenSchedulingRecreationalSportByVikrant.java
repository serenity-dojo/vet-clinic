package serenitylabs.tutorials.vetclinic.playingball;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.RecreationalSportsSchedule;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class WhenSchedulingRecreationalSportByVikrant {

    RecreationalSportsSchedule recreationalSportScheduler;

    private static final List<LocalDate> WEEKENDS = Lists.newArrayList(A_SATURDAY, A_SUNDAY);
    private static final List<LocalDate> WEEKDAYS = Lists.newArrayList(A_MONDAY, A_THURSDAY, A_TUESDAY, A_FRIDAY);

    @Before
    public void setup() {
        recreationalSportScheduler = new RecreationalSportsSchedule();
    }

    @Test
    public void should_play_football_on_the_weekends() {
        WEEKENDS.forEach(day -> assertThat(recreationalSportScheduler.forGameOn(day).play(), equalTo(Game.Football)));
    }

    @Test
    public void should_play_handball_during_the_week() {
        WEEKDAYS.forEach(day -> assertThat(recreationalSportScheduler.forGameOn(day).play(), equalTo(Game.Handball)));
    }
}
