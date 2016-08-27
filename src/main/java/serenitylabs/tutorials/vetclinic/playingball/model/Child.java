package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

public class Child {

    private final SportsSchedule sportsSchedule;

    public Child(SportsSchedule sportsSchedule) {
        this.sportsSchedule = sportsSchedule;
    }

    public Game goPlayBallOn(LocalDate someDay) {
        return sportsSchedule.forDate(someDay).play();
    }
}
