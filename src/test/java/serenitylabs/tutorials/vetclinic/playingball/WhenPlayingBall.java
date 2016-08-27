package serenitylabs.tutorials.vetclinic.playingball;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.Child;
import serenitylabs.tutorials.vetclinic.playingball.model.Game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.SampleDates.A_SUNDAY;

public class WhenPlayingBall {

    @Test
    public void should_play_football_on_sundays() {

        Child bill = new Child();

        Game gamePlayed = bill.goPlayBallOn(A_SUNDAY);

        assertThat(gamePlayed, equalTo(Game.Football));
    }

}
