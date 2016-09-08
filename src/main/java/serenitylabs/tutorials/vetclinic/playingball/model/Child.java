package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Child {

    SportsSchedule sportSchedule;

    public Child(SportsSchedule sportSchedule) {
        this.sportSchedule = sportSchedule;
    }

    public Game goPlayBallOn(LocalDate someDay) {

       return sportSchedule.forDate(someDay).play();
    }

}
