package serenitylabs.tutorials.vetclinic.playingball.model;

import java.time.LocalDate;
import java.time.Month;

public class SchoolSportsSchedule implements GameSchedule {
    @Override
    public PlayBall forGameOn(LocalDate currentDay) {
        if ((currentDay.getMonth() == Month.JUNE)
                || (currentDay.getMonth() == Month.JULY)
                || (currentDay.getMonth() == Month.AUGUST)
                || (currentDay.getMonth() == Month.SEPTEMBER)) {
            return new PlayCricket();
        }

        return new PlayTennis();
    }
}
