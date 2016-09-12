package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class SchoolSportScheduler implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate someDay) {
        return new PlayHandball();

//
//        if(someDay.getDayOfWeek() == DayOfWeek.WEDNESDAY){
//            return new PlayHandball();
//        }else {
//            return new PlayFootball();
//        }
    }
}
