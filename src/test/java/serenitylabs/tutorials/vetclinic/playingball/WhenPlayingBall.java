package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.SportsSchedule;

import java.time.LocalDate;

import static java.time.Month.AUGUST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenPlayingBall {

    static final LocalDate A_SATURDAY = LocalDate.of(2016, AUGUST, 27);
    static final LocalDate A_SUNDAY = LocalDate.of(2016, AUGUST, 28);
    static final LocalDate A_MONDAY = LocalDate.of(2016, AUGUST, 29);

    @Test
    public void should_play_football_on_sundays() {

        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_football_on_saturdays() {
        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_SATURDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_handball_on_weekdays() {
        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_MONDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }

    @Test
    public void should_play_tennis_on_wednesdays() {
        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_MONDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }
}
