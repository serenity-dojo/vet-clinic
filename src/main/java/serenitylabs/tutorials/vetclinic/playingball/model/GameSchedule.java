package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

/**
 * Created by kimahale on 9/8/2016.
 */
public interface GameSchedule {
    PlayBall forGameOn(LocalDate someDay);

   // PlayBall forGameOnByWeek(LocalDate currentDay);
}
