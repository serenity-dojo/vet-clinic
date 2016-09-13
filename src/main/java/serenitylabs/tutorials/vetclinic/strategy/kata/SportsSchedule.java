package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/13/2016.
 */
public class SportsSchedule {
    GameSchedule schoolSportScheduled = new SchoolSportSchedule();
    GameSchedule recreationaSportScheduled = new RecreationalSportsSchedule();

    public PlayBall forDate(LocalDate someDay) {
        if(someDay.getDayOfWeek()== DayOfWeek.WEDNESDAY)
            return schoolSportScheduled.forGameOn(someDay);
        else
            return recreationaSportScheduled.forGameOn(someDay);
    }

}
