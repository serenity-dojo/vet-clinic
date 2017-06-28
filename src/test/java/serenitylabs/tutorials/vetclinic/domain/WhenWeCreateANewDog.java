package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class WhenWeCreateANewDog {

    private final LocalDate THE_FOURTH_OF_JULY = LocalDate.of(2016,07,04);

    @Test
    public void a_new_dog_should_have_a_name_a_breed_a_colour_and_a_date_of_birth() throws Exception {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }

    @Test
    public void a_new_dog_should_optionally_have_a_favourite_food() throws Exception {
        Dog fido = Dog.called("Fido")
                      .ofBreed("Labrador")
                      .ofColour("Black")
                      .withFavouriteFood("pizza")
                      .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }
}
