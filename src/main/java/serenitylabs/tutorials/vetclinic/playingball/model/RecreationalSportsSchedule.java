package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by kimahale on 9/8/2016.
 */
public class RecreationalSportsSchedule implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate currentDay) {

        if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY || currentDay.getDayOfWeek()== DayOfWeek.SATURDAY)
            return new PlayFootBall();
        else
            return new PlayHandBall();

    }

    @Override
    public PlayBall forGameOnByWeek(LocalDate currentDay) {
        return null;
    }
}
