package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {
        assertThat(Arrays.asList(Colour.values()).stream().map(colour -> colour.toString()).collect(Collectors.toList()),
                containsInAnyOrder("Red", "Green", "Blue", "Orange", "Violet", "Yellow", "Black", "White"));
    }

    @Test
    public void should_identify_primary_colours() {
        assertThat(Colour.primaryColors(), containsInAnyOrder("Red", "Blue", "Green"));
    }

    @Test
    public void should_identify_non_primary_colours() {
        assertThat(Colour.nonPrimaryColors(), containsInAnyOrder("Orange", "Violet", "Yellow", "Black", "White"));
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
        assertThat(Colour.Black.isPrimary(),is(false) );
        assertThat(Colour.White.isPrimary(),is(false));
    }

    @Test
    public void red_is_the_opposite_of_green() {
        assertThat(Colour.oppositeOf(Colour.Red), is(Colour.Green));
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(Colour.oppositeOf(Colour.Blue), is(Colour.Orange));
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(Colour.oppositeOf(Colour.Yellow), is(Colour.Violet));
    }

    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(Colour.oppositeOf(Colour.Black), is(Colour.White));
    }

    @Test
    public void opposite_colours_are_symmetric() {
        Arrays.asList(Colour.values()).stream().forEach(colour ->
        {
            assertThat(colour.oppositeOf(colour.oppositeOf(colour)),is(colour));
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
        assertThat(Colour.oppositeOf(colour), is(expectedOpposite));
    }

}
