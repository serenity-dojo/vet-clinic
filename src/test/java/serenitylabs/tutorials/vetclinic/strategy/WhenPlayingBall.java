package serenitylabs.tutorials.vetclinic.strategy;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.strategy.model.Child;
import serenitylabs.tutorials.vetclinic.strategy.model.Game;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenPlayingBall {

    static final LocalDate A_WEEKEND_DAY = LocalDate.of(2016,8,27);
    static final LocalDate A_MONDAY = LocalDate.of(2016,8,22);

    @Test
    public void should_play_football_on_the_weekends() {
        Child child = new Child();

        Game gamePlayed = child.goPlayBallOn(A_WEEKEND_DAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_handball_in_the_week() {
        Child child = new Child();

        Game gamePlayed = child.goPlayBallOn(A_MONDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }
}
