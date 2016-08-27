package serenitylabs.tutorials.vetclinic.playingball;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.RecreationalSportsSchedule;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

public class WhenSchedulingRecreationalSport {

    static final List<LocalDate> WEEKEND_DAYS =  Lists.newArrayList(A_SATURDAY, A_SUNDAY);
    static final List<LocalDate> WEEK_DAYS =  Lists.newArrayList(A_MONDAY, A_TUESDAY, A_WEDNESDAY, A_THURSDAY, A_FRIDAY);

    GameSchedule scheduler;

    @Before
    public void setup() {
        scheduler = new RecreationalSportsSchedule();
    }

    @Test
    public void should_play_football_on_the_weekends() {
        WEEKEND_DAYS.forEach(
                day -> assertThat(scheduler.forGameOn(day).play(), equalTo(Game.Football))
        );
    }

    @Test
    public void should_play_handball_during_the_week() {
        WEEK_DAYS.forEach(
                day -> assertThat(scheduler.forGameOn(day).play(), equalTo(Game.Handball))
        );
    }

}
