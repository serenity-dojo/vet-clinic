package serenitylabs.tutorials.vetclinic.playingball.model;

import com.google.common.collect.Maps;

import java.applet.Applet;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by siddharthk on 9/7/2016.
 */
public class SportsSchedule {


    RecreationalSportsSchedule recretionalSportsSchedule = new RecreationalSportsSchedule();
    private static final Map<DayOfWeek,GameSchedule> scheduleMap = Maps.newHashMap();
    static {
        scheduleMap.put(DayOfWeek.WEDNESDAY, new SchoolSportsSchedule());
    }

    public PlayBall forDate(LocalDate someDay) {

        GameSchedule gameSchedule = scheduleMap.getOrDefault(someDay.getDayOfWeek(), recretionalSportsSchedule);
        return  gameSchedule.forGameOn(someDay);

    }

}
