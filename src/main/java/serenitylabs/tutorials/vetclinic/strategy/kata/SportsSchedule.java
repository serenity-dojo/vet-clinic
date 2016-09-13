package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/13/2016.
 */
public class SportsSchedule {
    GameSchedule scheduledSchoolSport = new SchoolSportsSchedule();
    GameSchedule scheduleRecreationalSport = new RecreationalSportsSchedule();

    public PlayBall forDate(LocalDate someDay) {
        if(someDay.getDayOfWeek()== DayOfWeek.WEDNESDAY)
            return scheduledSchoolSport.forGameOn(someDay);
        else
            return scheduleRecreationalSport.forGameOn(someDay);
    }

}
