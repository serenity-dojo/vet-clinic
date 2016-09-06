package serenitylabs.tutorials.vetclinic.enumerations.katas;

import org.hamcrest.Matcher;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashingInputStream;


import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.enumerations.colours.Colour;

@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColours {
    @Test
    public void should_know_about_all_the_main_colours() {
    List<String> colours = Arrays.asList(Colour.values()).stream().map(Colour::toString).collect(Collectors.toList());
    	
    	assertThat(colours, contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White"));
    	
    }

    @Test
    public void should_identify_primary_colours() {
    	List<Colour> primaryColours = ImmutableList.of(Colour.Red,Colour.Yellow,Colour.Blue);
    	
    	primaryColours.forEach(colour-> {
            assertThat(colour.isPrimary(), is(true));
        }
    	);
    }

	@Test
    public void should_identify_non_primary_colours() {
		
		List<Colour> nonPrimaryColours = ImmutableList.of(Colour.Orange,Colour.Green,Colour.Violet, Colour.Black, Colour.White);
		
		nonPrimaryColours.forEach(colour->{
			assertThat(colour.isPrimary(), is(false));
		}		
				);
    }

    @Test
    public void black_and_white_are_not_considered_primary() {
    	List<Colour> notPrimary = ImmutableList.of(Colour.Black, Colour.White);
		
		notPrimary.forEach(colour->{
			assertThat(colour.isPrimary(), is(false));
		}		
				);
    	
    }

    @Test
    public void red_is_the_opposite_of_green() {
    	assertThat(Colour.Red.theOpposite(), is(Colour.Green));
    }

    @Test
    public void blue_is_the_opposite_of_orange() {
    	assertThat(Colour.Blue.theOpposite(), is(Colour.Orange));
    }

    @Test
    public void yellow_is_the_opposite_of_violet() {
    	assertThat(Colour.Yellow.theOpposite(), is(Colour.Violet));
    }

    @Test
    public void black_is_the_opposite_of_white() {
    	assertThat(Colour.Black.theOpposite(), is(Colour.White));
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
    	assertThat(colour.theOpposite(),is(expectedOpposite));
    }
   
    @Test
    public void opposite_colours_are_symmetric() {
    	
    	newArrayList(Colour.values()).stream()
        .forEach(
                colour -> {
                    assertThat(colour.theOpposite().theOpposite(), is(colour));
                }
        );
}
}
