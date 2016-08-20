package serenitylabs.tutorials.vetclinic.enumerations.katas;

import com.google.common.collect.ImmutableList;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.collections.katas.colours.Colour;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {

        List<String> colours = newArrayList(Colour.values()).stream()
                .map(Colour::toString)
                .collect(Collectors.toList());
        assertThat(colours, contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White"));
    }

    @Test
    public void should_identify_primary_colours() {
        List<Colour> expectedPrimaries = ImmutableList.of(Colour.Red, Colour.Yellow, Colour.Blue);

        expectedPrimaries.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(true));
                }
        );
    }

    @Test
    public void should_identify_non_primary_colours() {
        List<Colour> expectedPrimaries = ImmutableList.of(Colour.Green, Colour.Orange, Colour.Violet);

        expectedPrimaries.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(false));
                }
        );
    }

    @Test
    public void black_and_white_are_not_considered_primary() {

        assertThat(Colour.Black.isPrimary(), is(false));
        assertThat(Colour.White.isPrimary(), is(false));

    }

    @Test
    public void red_is_the_opposite_of_green() {
        assertThat(Colour.Red.getOpposite(), is(Colour.Green));
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(Colour.Blue.getOpposite(), is(Colour.Orange));
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(Colour.Yellow.getOpposite(), is(Colour.Violet));
    }

    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(Colour.Black.getOpposite(), is(Colour.White));
    }

    @Parameters({"Red,    Green",
                 "Blue,   Orange",
                 "Violet, Yellow",
                 "Black,  White"})
    @Test
    public void should_identify_opposite_colours(Colour colour, Colour expectedOpposite) throws Exception {
        assertThat(colour.getOpposite(), is(expectedOpposite));
    }

    @Test
    public void opposite_colours_are_symmetric() {
        newArrayList(Colour.values()).stream()
                .forEach(
                        colour -> {
                            assertThat(colour.getOpposite().getOpposite(), is(colour));
                        }
                );
    }

}
