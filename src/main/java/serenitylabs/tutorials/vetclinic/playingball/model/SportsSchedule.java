package serenitylabs.tutorials.vetclinic.playingball.model;

import java.applet.Applet;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by siddharthk on 9/7/2016.
 */
public class SportsSchedule {

    RecreationalSportsSchedule recretionalSportsSchedule = new RecreationalSportsSchedule();
    SchoolSportsSchedule schoolSportsSchedule = new SchoolSportsSchedule();

    public PlayBall forDate(LocalDate someDay) {

        if (someDay.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            return schoolSportsSchedule.forGameOn(someDay);

        } else {
            return recretionalSportsSchedule.forGameOn(someDay);

        }
    }

}
