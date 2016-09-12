package serenitylabs.tutorials.vetclinic.strategy.kata;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;


import static com.sun.javafx.fxml.expression.Expression.notEqualTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by pravyada on 9/12/2016.
 */
public class WhenPlaingBall {

    private LocalDate A_SUNDAY = LocalDate.of(2016,8,28);
    private LocalDate A_SATURDAY = LocalDate.of(2016,8,27);
    private LocalDate A_FRIDAY = LocalDate.of(2016,8,26);
    @Test
    public void should_play_football_on_sunday(){
    Child bill = new Child();
    Game gamePalyed = bill.goPlayBallOn(A_SUNDAY);
    assertThat(gamePalyed,is(equalTo(Game.FOOTBOLL)));
    }

    @Test
    public void should_play_football_on_saturday(){
        Child bill = new Child();
        Game gamePlayed = bill.goPlayBallOn(A_SATURDAY);
    }

    @Test
    public void should_play_handball_on_weekdays(){
        Child bill = new Child();
        Game gamePalyed = bill.goPlayBallOn(A_FRIDAY);
        assertThat(gamePalyed,is(equalTo(Game.HANDBOLL)));
    }

    @Test
    public void should_play_tennis_on_wensday(){
        Child bill = new Child();
        Game gamePalyed = bill.goPlayBallOn(A_FRIDAY.minusDays(1));
        assertThat(gamePalyed,is(equalTo(Game.HANDBOLL)));
    }

}
