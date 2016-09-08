package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;
import serenitylabs.tutorials.vetclinic.playingball.model.SportsSchedule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.*;

public class WhenPlayingBall {

    Child bill;

    @Before
    public void setUp() throws Exception {
        SportsSchedule sportsSchedule = new SportsSchedule();
         bill = new Child(sportsSchedule);

    }

    @Test
    public void should_play_football_on_sundays() {

        Game gamePlayed = bill.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_football_on_saturdays(){

        Game gamePlayed = bill.goPlayBallOn(A_SATURDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

    @Test
    public void should_play_handball_on_week_days(){

        Game gamePlayed = bill.goPlayBallOn(A_MONDAY);

        assertThat(gamePlayed, equalTo(Game.Handball));
    }

    @Test
    public void should_play_tennis_on_wednesdays(){

        Game gamePlayed = bill.goPlayBallOn(A_WEDNESDAY);

        assertThat(gamePlayed, equalTo(Game.Cricket));
    }
}
