package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;
import java.time.Month;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.Month.*;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SchoolSportsSchedule implements GameSchedule {

    @Override
    public PlayBall forGameOn(LocalDate currentDay) {
            if(currentDay.getMonth() == JUNE || currentDay.getMonth() == JULY || currentDay.getMonth() == AUGUST || currentDay.getMonth() == SEPTEMBER ){
                return new PlayCricket();
            }
            return new PlayTennis();
    }
}
