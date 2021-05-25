package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenWeCreateANewDog {

    private static final LocalDateTime THE_FOURTH_OF_JULY = LocalDateTime.now();
    LocalDateTime dateOfBirth = LocalDateTime.now();

    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .bornOn(dateOfBirth);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
        Assert.assertEquals(dateOfBirth, fido.getDateOfBirth());


    }

   @Test
    public void a_dog_can_have_an_optional_favourite_food() {

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .hasFavouriteFood("Pizza")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
        Assert.assertEquals("Black", fido.getColour());
        Assert.assertEquals("Pizza", fido.getFavouriteFood());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_toy() {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("Black")
                .hasFavouriteFood("Pizza")
                .hasFavouriteToy("Ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
        Assert.assertEquals("Black", fido.getColour());
        Assert.assertEquals("Pizza", fido.getFavouriteFood());
        Assert.assertEquals("Ball", fido.getFavouriteToy());
    }
}
