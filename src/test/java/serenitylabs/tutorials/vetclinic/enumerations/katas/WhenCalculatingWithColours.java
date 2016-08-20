package serenitylabs.tutorials.vetclinic.enumerations.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {
    }

    @Test
    public void should_identify_primary_colours() {
    }

    @Test
    public void should_identify_non_primary_colours() {
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
