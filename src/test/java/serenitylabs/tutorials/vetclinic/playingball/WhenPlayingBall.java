package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.SportsSchedule;

import java.awt.*;
import java.time.LocalDate;

import static java.util.Calendar.AUGUST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

public class WhenPlayingBall {

    @Test
    public void should_play_football_on_sundays() {

        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_football_on_saturdays() throws Exception {

        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_SATURDAY);

        assertThat(gamePlayed, equalTo(Game.Football));

    }

    @Test
    public void should_play_handball_on_week_days() throws Exception {

        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_TUESDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }

    @Test
    public void should_play_tennis_on_wednesdays() throws Exception {

        SportsSchedule sportsSchedule = new SportsSchedule();
        Child bill = new Child(sportsSchedule);

        Game gamePlayed = bill.goPlayBallOn(A_WEDNESDAY);

        assertThat(gamePlayed, equalTo(Game.Tennis));

    }
}
