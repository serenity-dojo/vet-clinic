package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {

        List<String> colorNames = Arrays.stream(Colour.values()).map(c -> c.name()).collect(Collectors.toList());
        assertThat(colorNames, containsInAnyOrder("Red", "Orange", "Yellow", "Green", "Blue", "Violet",
                "Black","White"));
    }

    @Test
    public void should_identify_primary_colours() {
        List<String>  primaryColourList = Arrays.stream(Colour.values()).filter(c -> c.isPrimary()).map(c -> c.name()).collect(Collectors.toList());
        assertThat(primaryColourList,containsInAnyOrder("Red","Yellow","Blue"));
    }

    @Test
    public void should_identify_non_primary_colours() {
        List<String> nonPrimaryColourList = Arrays.stream(Colour.values()).filter(c -> !c.isPrimary()).map(c -> c.name()).collect(Collectors.toList());
        assertThat(nonPrimaryColourList,containsInAnyOrder("Orange", "Green",  "Violet","Black","White"));
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
        List<String>  primaryColourList = Arrays.stream(Colour.values()).filter(c -> c.isPrimary()).map(c -> c.name()).collect(Collectors.toList());
        assertThat(primaryColourList,not(contains("black","White")));
    }

    @Test
    public void red_is_the_opposite_of_green() {

        assertThat(Colour.Red.getOppositeColor(),is(Colour.Green));
        assertThat(Colour.Green.getOppositeColor(),is(Colour.Red));
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(Colour.Blue.getOppositeColor(),is(Colour.Orange));
        assertThat(Colour.Orange.getOppositeColor(),is(Colour.Blue));
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(Colour.Yellow.getOppositeColor(),is(Colour.Violet));
        assertThat(Colour.Violet.getOppositeColor(),is(Colour.Yellow));
    }

    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(Colour.Black.getOppositeColor(),is(Colour.White));
        assertThat(Colour.White.getOppositeColor(),is(Colour.Black));
    }

    @Test
    public void opposite_colours_are_symmetric() {

        Arrays.stream(Colour.values()).forEach(colour -> {
            assertThat(colour.getOppositeColor().getOppositeColor(), is(colour));
        });
    }

    /**
     * This is an example of an alternative approach using JUnitParam
     */
    @Parameters({"Red,    Green",
            "Blue,   Orange",
            "Violet, Yellow",
            "Black,  White"})
    @Test
    public void should_identify_opposite_colours(Colour colour, Colour expectedOpposite) throws Exception {
         assertThat(colour.getOppositeColor(),is(expectedOpposite));
    }

}
