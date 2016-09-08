package serenitylabs.tutorials.vetclinic.playingball;

import org.assertj.core.internal.Lists;
import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.RecreationalSportsSchedule;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

/**
 * Created by siddharthk on 9/6/2016.
 */
public class WhenSchedulingRecreationalSport {

    private List<LocalDate> weekendDates = newArrayList(A_SATURDAY,A_SUNDAY);
    private List<LocalDate> weekdayDates = newArrayList(A_MONDAY,A_TUESDAY,A_WEDNESDAY,A_THURSDAY,A_FRIDAY);

    GameSchedule gameSchedule;

    @Before
    public void setUp() throws Exception {
        gameSchedule = new RecreationalSportsSchedule();
    }

    @Test
    public void should_play_football_on_the_weekends(){
        weekendDates.forEach(w->assertThat(gameSchedule.forGameOn(w).play(),equalTo(Game.Football)));
    }

    @Test
    public void should_play_football_on_the_weekdays(){
        weekdayDates.forEach(w->assertThat(gameSchedule.forGameOn(w).play(),equalTo(Game.Handball)));
    }
}
