package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {
        List<String> colors =Arrays.asList(Colour.values()).stream().map(colour -> colour.toString()).collect(Collectors.toList());
        assertThat(colors,containsInAnyOrder("Red","Green","Blue","Orange","Violet","Yellow","Black","White"));
    }

    @Test
    public void should_identify_primary_colours() {
        assertThat(Colour.primaryColors(),containsInAnyOrder("Red","Blue","Green"));
    }

    @Test
    public void should_identify_non_primary_colours() {
        assertThat(Colour.nonPrimaryColors(),containsInAnyOrder("Orange","Violet","Yellow","Black","White"));
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
    }

    @Test
    public void red_is_the_opposite_of_green() {
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
    }

    @Test
    public void black_is_the_opposite_of_white() {
    }

    @Test
    public void opposite_colours_are_symmetric() {
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
    }

}
