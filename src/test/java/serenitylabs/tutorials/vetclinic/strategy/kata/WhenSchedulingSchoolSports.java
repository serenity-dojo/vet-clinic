package serenitylabs.tutorials.vetclinic.strategy.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by pravyada on 9/12/2016.
 */

@RunWith(Parameterized.class)
public class WhenSchedulingSchoolSports {

    @Parameterized.Parameters
    public static Collection<Object> getDates(){
        Collection<Object> systemDates = new ArrayList<Object>();

        return systemDates;
    }
    @Test
    public void tennis_should_be_scheduled_in_winter(){

    }

    @Test
    public void cricket_should_be_scheduled_in_summer(){

    }
}
