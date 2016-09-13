package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class SportsScheduler implements GameSchedule {

    GameSchedule schoolSportScheduled = new SchoolSportsSchedule();
    GameSchedule recreationaSportScheduled = new RecreationalSportsSchedule();

    @Override
    public PlayBall forGameOn(LocalDate someDay) {
        if(someDay.getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return schoolSportScheduled.forGameOn(someDay);
        }else {
            return recreationaSportScheduled.forGameOn(someDay);
        }
    }

    public void play(){
        System.out.println("Playing game");
    }
}
