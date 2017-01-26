package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.DayOfWeek.*;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/31/16
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SportsSchedule {

    GameSchedule schoolSports = new SchoolSportsSchedule();
    GameSchedule recreationalSports = new RecreationalSportsSchedule();

    public PlayBall forDay(LocalDate playDay) {
        if(playDay.getDayOfWeek() == WEDNESDAY) {
            return schoolSports.forGameOn(playDay);
        }
        else {
            return recreationalSports.forGameOn(playDay);
        }
    }
}

