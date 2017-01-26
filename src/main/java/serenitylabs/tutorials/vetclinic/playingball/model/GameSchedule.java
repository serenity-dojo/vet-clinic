package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/30/16
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GameSchedule {

    PlayBall forGameOn(LocalDate someDay);
}
