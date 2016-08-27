package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

public interface GameSchedule {
    PlayBall forGameOn(LocalDate someDay);
}
