package serenitylabs.tutorials.vetclinic.playingball.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Map;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

public class GameSchedule {
    private static final Collection<Month> SUMMER_MONTHS = ImmutableList.of(JUNE, JULY, AUGUST, SEPTEMBER);

    private static Map<DayOfWeek, PlayBall> WINTER_SCHEDULE = Maps.newHashMap();

    static {
        WINTER_SCHEDULE.put(SATURDAY,   new PlayFootball());
        WINTER_SCHEDULE.put(SUNDAY,     new PlayFootball());
        WINTER_SCHEDULE.put(MONDAY,     new PlayHandball());
        WINTER_SCHEDULE.put(TUESDAY,    new PlayHandball());
        WINTER_SCHEDULE.put(WEDNESDAY,  new PlayTennis());
        WINTER_SCHEDULE.put(THURSDAY,   new PlayHandball());
        WINTER_SCHEDULE.put(FRIDAY,     new PlayHandball());
    }

    private static Map<DayOfWeek, PlayBall> SUMMER_SCHEDULE = Maps.newHashMap();

    static {
        SUMMER_SCHEDULE.put(SATURDAY,   new PlayFootball());
        SUMMER_SCHEDULE.put(SUNDAY,     new PlayFootball());
        SUMMER_SCHEDULE.put(MONDAY,     new PlayHandball());
        SUMMER_SCHEDULE.put(TUESDAY,    new PlayHandball());
        SUMMER_SCHEDULE.put(WEDNESDAY,  new PlayCricket());
        SUMMER_SCHEDULE.put(THURSDAY,   new PlayHandball());
        SUMMER_SCHEDULE.put(FRIDAY,     new PlayHandball());
    }

    public static Map<DayOfWeek, PlayBall> forDate(LocalDate currentDay) {
        return (inSummer(currentDay)) ? SUMMER_SCHEDULE : WINTER_SCHEDULE;
    }

    private static boolean inSummer(LocalDate currentDay) {
        return SUMMER_MONTHS.contains(currentDay.getMonth());
    }
}
