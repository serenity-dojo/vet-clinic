package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class SchoolSportsSchedule implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate someDay) {
        if(someDay.getMonth().getValue()>=6 && someDay.getMonth().getValue()<=9) {
            return new PlayCricket();
        }
        else {
            return new PlayTennis();
        }
}
}
