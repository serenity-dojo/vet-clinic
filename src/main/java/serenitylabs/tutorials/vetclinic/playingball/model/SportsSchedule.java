package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by kimahale on 9/8/2016.
 */
public class SportsSchedule {

    GameSchedule sportsSchedule = new SchoolSportsSchedule();
    GameSchedule recreationalSportScheduled = new RecreationalSportsSchedule();

    public PlayBall forDate(LocalDate currentDay) {
        if (currentDay.getDayOfWeek()== DayOfWeek.WEDNESDAY)
            return sportsSchedule.forGameOnByWeek(currentDay);
        else
            return recreationalSportScheduled.forGameOn(currentDay);

    }
}
