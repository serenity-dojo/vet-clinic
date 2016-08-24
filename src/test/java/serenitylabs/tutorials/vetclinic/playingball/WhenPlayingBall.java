package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenPlayingBall {

    static final LocalDate A_WEEKEND_DAY = LocalDate.of(2016, 8, 27);
    static final LocalDate A_MONDAY = LocalDate.of(2016, 8, 22);
    static final LocalDate A_WEDNESDAY = LocalDate.of(2016, 1, 06);
    static final LocalDate A_WEDNESDAY_IN_SUMMER = LocalDate.of(2016, 8, 24);


    @Test
    public void should_play_football_on_the_weekends() {
        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_WEEKEND_DAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_handball_in_the_week() {
        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_MONDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }

    @Test
    public void should_play_tennis_on_wednesdays() {
        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_WEDNESDAY);

        assertThat(gamePlayed, equalTo(Game.Tennis));

    }

    @Test
    public void should_play_cricket_on_wednesdays_in_summer() {
        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_WEDNESDAY_IN_SUMMER);

        assertThat(gamePlayed, equalTo(Game.Cricket));

    }
}
