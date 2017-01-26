package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;


/**
 * Created by siddharthk on 9/6/2016.
 */
public class RecreationalSportsSchedule implements GameSchedule{

    @Override
    public PlayBall forGameOn(LocalDate someDay) {
        if ((someDay.getDayOfWeek() == SATURDAY) || (SUNDAY == someDay.getDayOfWeek())) {
            return new PlayFootball();
        }
        return new PlayHandball();
    }
}
