package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by kimahale on 9/8/2016.
 */
public class SchoolSportsSchedule implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate currentDay) {

        //System.out.println(currentDay.getMonth().toString());

        if (currentDay.getMonth() == Month.JUNE
                        || currentDay.getMonth() == Month.JULY
                        || currentDay.getMonth() == Month.AUGUST
                        || currentDay.getMonth() == Month.SEPTEMBER) {
            return new PlayCricket();
        }

        return new PlayTennis();
    }

}
