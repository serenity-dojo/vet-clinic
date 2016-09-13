package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class Child {

    SportsSchedule sportsSchedule;
    Child(SportsSchedule sportsSchedule){
        this.sportsSchedule = sportsSchedule;
    }

    public Game goPlayBallOn(LocalDate someDay) {
        return sportsSchedule.forDate(someDay).play();
    }
}
