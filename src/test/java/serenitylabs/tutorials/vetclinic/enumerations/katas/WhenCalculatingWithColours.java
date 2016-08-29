package serenitylabs.tutorials.vetclinic.enumerations.katas;

import com.google.common.collect.ImmutableList;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {

        List<String> colours = Arrays.asList(Colour.values()).stream().map(Colour::toString).collect(Collectors.toList());

        assertThat(colours,contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White"));

    }

    @Test
    public void should_identify_primary_colours() {
        List<Colour> expectedPrimary = ImmutableList.of(Colour.Red,Colour.Yellow, Colour.Blue);

        expectedPrimary.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(true));
                }
        );


    }

    @Test
    public void should_identify_non_primary_colours() {
        List<Colour> expectedPrimary = ImmutableList.of(Colour.Orange,Colour.Green, Colour.Violet, Colour.Black, Colour.White );

        expectedPrimary.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(false));
                }
        );
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
        List<Colour> expectedPrimary = ImmutableList.of(Colour.Black, Colour.White );

        expectedPrimary.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(false));
                }
        );
    }

    @Test
    public void red_is_the_opposite_of_green() {
        assertThat(Colour.Red.getOpposite(),is(Colour.Green));
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(Colour.Blue.getOpposite(),is(Colour.Orange));
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(Colour.Yellow.getOpposite(),is(Colour.Violet));
    }

    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(Colour.Black.getOpposite(),is(Colour.White));
    }

    @Test
    public void opposite_colours_are_symmetric() {

       //  List<String> colours = Arrays.asList(Colour.values()).stream().map(Colour::toString).collect(Collectors.toList());
        // assertThat(colour.getOpposite(), is(colour));

        Arrays.asList(Colour.values()).stream().forEach(
                colour -> {

                    assertThat(colour.getOpposite().getOpposite(), is(colour));
                }
        );

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
        assertThat(colour.getOpposite(), is(expectedOpposite));
    }

}
