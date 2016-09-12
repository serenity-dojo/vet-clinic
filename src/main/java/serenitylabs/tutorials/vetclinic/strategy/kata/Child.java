package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class Child {

    public Game goPlayBallOn(LocalDate currentDate) {
        if(currentDate.getDayOfWeek()== DayOfWeek.SATURDAY || currentDate.getDayOfWeek()== DayOfWeek.SUNDAY)
        return Game.FOOTBOLL;
        else if(currentDate.getDayOfWeek()== DayOfWeek.WEDNESDAY)
            return Game.TENNIS;
        else
            return Game.HANDBOLL;
    }
}
