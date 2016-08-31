package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.SportsSchedule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

public class WhenPlayingBall {

    SportsSchedule sportsSchedule = new SportsSchedule();
    Child vikrant;

    @Before
    public void setup() {
        vikrant = new Child(sportsSchedule);
    }

    @Test
    public void should_play_football_on_sundays() {

        Game gamePlayed = vikrant.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_football_on_saturdays() {

        //WHEN
        Game gamePlayed = vikrant.goPlayBallOn(A_SATURDAY);

        //THEN
        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_handball_on_week_days() {

        //WHEN
        Game gamePlayed = vikrant.goPlayBallOn(A_THURSDAY);

        //THEN
        assertThat(gamePlayed, equalTo(Game.Handball));
    }

  /*  @Test
    public void should_play_tennis_on_wednesdays() {

        //WHEN
        Game gamePlayed = vikrant.goPlayBallOn(A_WEDNESDAY);

        //THEN
        assertThat(gamePlayed, equalTo(Game.Tennis));

    }*/

    @Test
    public void should_play_cricket_in_the_summer_months_and_tennis_in_winter_months() throws Exception {
        Assert.assertThat(sportsSchedule.forDay(A_WEDNESDAY).play(), equalTo(Game.Cricket));
    }
}
