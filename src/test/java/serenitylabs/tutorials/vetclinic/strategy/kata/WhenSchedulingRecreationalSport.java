package serenitylabs.tutorials.vetclinic.strategy.kata;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by pravyada on 9/12/2016.
 */
public class WhenSchedulingRecreationalSport {

    private LocalDate A_SUNDAY = LocalDate.of(2016,8,28);
    private LocalDate A_SATURDAY = LocalDate.of(2016,8,27);
    private LocalDate A_FRIDAY = LocalDate.of(2016,8,26);
    @Test
    public void should_play_football_on_the_weekends(){

        RecreationalSportsSchedule recreationalSportsSchedule = new RecreationalSportsSchedule();
        PlayBall playBall = recreationalSportsSchedule.forGameOn(A_SATURDAY);

        assertThat(playBall.play(),is(equalTo(Game.FOOTBOLL)));
    }
}
