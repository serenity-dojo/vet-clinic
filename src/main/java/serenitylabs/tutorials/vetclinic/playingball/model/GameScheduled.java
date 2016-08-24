package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

public class GameScheduled {

    public static PlayBall on(LocalDate currentDay) {
        return GameSchedule.forDate(currentDay).get(currentDay.getDayOfWeek());
    }
}
