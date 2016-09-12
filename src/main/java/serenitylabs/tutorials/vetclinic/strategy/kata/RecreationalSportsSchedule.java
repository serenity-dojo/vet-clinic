package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class RecreationalSportsSchedule implements GameSchedule {
    public PlayBall forGameOn(LocalDate currentDay) {
        if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY || currentDay.getDayOfWeek() == DayOfWeek.SATURDAY){
            return new PlayFootball();
    }else
        return new PlayHandball();
    }
}
