package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecreationalSportsSchedule implements GameSchedule {

    @Override
    public PlayBall forGameOn(LocalDate currentDay) {
        if ((currentDay.getDayOfWeek() == SATURDAY) || (currentDay.getDayOfWeek() == SUNDAY)) {
            return new PlayFootball();
        }
        return new PlayHandball();
    }
}
