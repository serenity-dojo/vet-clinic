package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;

public class RecreationalSportsSchedule implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate currentDay) {
        if ((currentDay.getDayOfWeek() == SATURDAY) || (currentDay.getDayOfWeek() == SUNDAY)) {
            return new PlayFootball();
        }
        return new PlayHandball();
    }
}
