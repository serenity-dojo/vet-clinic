package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class WhenWeCreateANewDog {

    private final static LocalDate THE_FOURTH_OF_JULY  = LocalDate.of(2020,07,04);

    @Test
    public void a_new_dog_should_have_a_name_a_breed_a_colour_and_a_date_of_birth() throws Exception {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black", fido.getColour());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_food() throws Exception{
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .withFavouriteFood("pizza")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black", fido.getColour());
        Assert.assertEquals("pizza", fido.getFavouriteFood());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }

    @Test
    public void  a_dog_can_have_an_optional_favourite_toy() throws Exception{
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .withFavouriteToy("bone")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black",fido.getColour());
        Assert.assertEquals("bone", fido.getFavouriteToy());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }

    @Test
    public void a_new_dog_should_have_a_name() throws Exception {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .withFavouriteToy("bone")
                .bornOn(THE_FOURTH_OF_JULY);

        System.out.println(fido.getName() + " was born on " + fido.getDateOfBirth());

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());

    }


}
