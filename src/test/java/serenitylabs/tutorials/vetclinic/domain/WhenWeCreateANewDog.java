package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.StrictAssertions.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class WhenWeCreateANewDog {

    private static final LocalDateTime THE_FOURTH_OF_JULY = LocalDateTime.now();
    LocalDateTime dateOfBirth = LocalDateTime.now();

    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = DogBreeder.aLargeDog()
                .called("Fido")
                .ofColour("Black")
                .bornOn(dateOfBirth);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
        Assert.assertEquals(dateOfBirth, fido.getDateOfBirth());


    }

   @Test
    public void a_dog_can_have_an_optional_favourite_food() {

        Dog sport = DogBreeder.aSmallDog()
                 .called("Sport")
                .ofColour("Black")
                .hasFavouriteFood("Pizza")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Sport", sport.getName());
        Assert.assertEquals("Poodle", sport.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, sport.getDateOfBirth());
        Assert.assertEquals("Black", sport.getColour());
        Assert.assertEquals("Pizza", sport.getFavouriteFood());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_toy() {
        Dog jackie = DogBreeder.aGuardDog()
                .called("Jackie")
                .ofColour("Black")
                .hasFavouriteFood("Pizza")
                .hasFavouriteToy("Ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Jackie", jackie.getName());
        Assert.assertEquals("Bull Dog", jackie.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, jackie.getDateOfBirth());
        Assert.assertEquals("Black", jackie.getColour());
        Assert.assertEquals("Pizza", jackie.getFavouriteFood());
        Assert.assertEquals("Ball", jackie.getFavouriteToy());
    }

    @Test
    public void a_dog_has_more_than_one_colour() {
        Dog fido = DogBreeder.aLargeDog()
                .called("Fido")
                .ofColour("Black","Brown")
                .bornOn(dateOfBirth);

        assertThat(fido.getColour(),hasItem("Brown"));
        assertThat(fido.getColour(), Matchers.not(hasItem("Red ")));




    }
}
