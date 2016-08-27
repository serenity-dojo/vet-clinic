package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

import static java.time.DayOfWeek.WEDNESDAY;

public class SportsSchedule {

    GameSchedule schoolSportScheduled = new SchoolSportsSchedule();
    GameSchedule recreationalSportScheduled = new RecreationalSportsSchedule();

    public PlayBall forDate(LocalDate currentDay) {
        if (currentDay.getDayOfWeek() == WEDNESDAY) {
            return schoolSportScheduled.forGameOn(currentDay);
        } else {
            return recreationalSportScheduled.forGameOn(currentDay);
        }
    }
}
