package serenitylabs.tutorials.vetclinic.playingball.model;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

public class Child {

    private final SportsSchedule sportsSchedule;

    public Child(SportsSchedule sportsSchedule) {
        this.sportsSchedule = sportsSchedule;
    }

    public Game goPlayBallOn(LocalDate playDay) {
        return sportsSchedule.forDay(playDay).play();
    }
}
