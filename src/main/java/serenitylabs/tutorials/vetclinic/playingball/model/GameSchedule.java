package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

/**
 * Created by siddharthk on 9/6/2016.
 */
public interface GameSchedule {
    PlayBall forGameOn(LocalDate someDay);
}
