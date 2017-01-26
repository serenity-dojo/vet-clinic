package serenitylabs.tutorials.vetclinic.playingball.model;

import com.google.common.collect.Lists;
import serenitylabs.tutorials.vetclinic.playingball.model.GameSchedule;
import serenitylabs.tutorials.vetclinic.playingball.model.PlayBall;
import serenitylabs.tutorials.vetclinic.playingball.model.PlayCricket;
import serenitylabs.tutorials.vetclinic.playingball.model.PlayTennis;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Created by siddharthk on 9/6/2016.
 */
public class SchoolSportsSchedule implements GameSchedule {

    List<Month> WINTER_SEASON = Lists.newArrayList(Month.OCTOBER,Month.SEPTEMBER,Month.NOVEMBER,Month.DECEMBER);
    @Override
    public PlayBall forGameOn(LocalDate someDay) {

        PlayBall gameToPlay = WINTER_SEASON.contains(someDay.getMonth()) ? new PlayTennis() : new PlayCricket();
        return  gameToPlay;
    }
}
