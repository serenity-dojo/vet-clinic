package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

}
