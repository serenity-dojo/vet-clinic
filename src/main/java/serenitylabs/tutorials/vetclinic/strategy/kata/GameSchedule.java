package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public interface GameSchedule {

    PlayBall forGameOn(LocalDate someDay);
}
