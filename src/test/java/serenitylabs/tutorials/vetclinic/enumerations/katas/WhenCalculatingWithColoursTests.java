package serenitylabs.tutorials.vetclinic.enumerations.katas;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static com.google.common.collect.Lists.newArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.runner.RunWith;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableList;
import junitparams.JUnitParamsRunner;
import serenitylabs.tutorials.vetclinic.enumerations.colours.ColourEnum;

/*
 * This Test class contains and runs test cases based on both TestNg and Junit Tests
 * 
 */
@RunWith(JUnitParamsRunner.class)
public class WhenCalculatingWithColoursTests {
	
    @Test
    public void should_know_about_all_the_main_colours() {
        List<String> colours = newArrayList(ColourEnum.values()).stream()
                .map(ColourEnum::toString)
                .collect(Collectors.toList());
        assertThat(colours, contains("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Black", "White"));
        System.out.println("\nTC-01 Executed - should_know_about_all_the_main_colours");
    }

    
    @Test
    public void should_identify_primary_colours() {
        List<ColourEnum> expectedPrimaries = ImmutableList.of(ColourEnum.Red, ColourEnum.Yellow, ColourEnum.Blue);

        expectedPrimaries.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(true));
                }
        );
        System.out.println("\nTC-02 Executed - should_identify_primary_colours");
    }

    
    @Test
    public void should_identify_non_primary_colours() {
        List<ColourEnum> expectedPrimaries = ImmutableList.of(ColourEnum.Green, ColourEnum.Orange, ColourEnum.Violet);

        expectedPrimaries.forEach(
                colour -> {
                    assertThat(colour.isPrimary(), is(false));
                }
        );
        System.out.println("\nTC-03 Executed - should_identify_non_primary_colours");
    }

    
    @Test
    public void black_and_white_are_not_considered_primary() {

        assertThat(ColourEnum.Black.isPrimary(), is(false));
        assertThat(ColourEnum.White.isPrimary(), is(false));
        System.out.println("\nTC-04 Executed - black_and_white_are_not_considered_primary");
    }

    
    @Test
    public void red_is_the_opposite_of_green() {
        assertThat(ColourEnum.Red.opposite(), is(ColourEnum.Green));
        System.out.println("\nTC-05 Executed - red_is_the_opposite_of_green");
    }

    
    @Test
    public void blue_is_the_opposite_of_orange() {
        assertThat(ColourEnum.Blue.opposite(), is(ColourEnum.Orange));
        System.out.println("\nTC-06 Executed - blue_is_the_opposite_of_orange");
    }

    
    @Test
    public void yellow_is_the_opposite_of_violet() {
        assertThat(ColourEnum.Yellow.opposite(), is(ColourEnum.Violet));
        System.out.println("\nTC-07 Executed - yellow_is_the_opposite_of_violet");
    }

    
    @Test
    public void black_is_the_opposite_of_white() {
        assertThat(ColourEnum.Black.opposite(), is(ColourEnum.White));
        System.out.println("\nTC-08 Executed - black_is_the_opposite_of_white");
    }

    
    /*
     * This is junits parameterized test
     */
    @Parameters({"Red,Green",
                 "Blue,Orange",
                 "Violet,Yellow",
                 "Black,White"})
    @org.junit.Test
    public void should_identify_opposite_colours(ColourEnum colour, ColourEnum expectedOpposite) throws Exception {
        assertThat(colour.opposite(),is(expectedOpposite));
        System.out.println("\nTC-09 Executed - should_identify_opposite_colours");
    }

    
    @Test
    public void opposite_colours_are_symmetric() {
        newArrayList(ColourEnum.values()).stream()
                .forEach(
                        colour -> {
                            assertThat(colour.opposite().opposite(),is(colour));
                        }
                );
        System.out.println("\nTC-10 Executed - opposite_colours_are_symmetric");
    }
	
    
}