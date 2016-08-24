package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

public class Child {
    public Game goPlayBallOn(LocalDate currentDay) {
        return GameScheduled.on(currentDay).play();
    }
}
