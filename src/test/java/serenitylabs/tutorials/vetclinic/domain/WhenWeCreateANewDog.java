package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertEquals("Fido",fido.getName());
        assertEquals("Labrador", fido.getBreed());
        assertEquals("Black", fido.getColour());
    }

    @Test
    public void a_dog_should_be_printed_in_a_readable_form(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(), is(equalTo("Fido the black labrador")));//can be without "is", added for more readability
        assertThat(fido.toString(), startsWith("Fido"));
        assertThat(fido.toString(), endsWith("labrador"));
        assertThat(fido.toString(), containsString("black"));
    }
    @Test
    public void a_dog_can_have_multiple_colors() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black", "Brown");

        assertThat(fido.getColour(), contains("Black","Brown"));
        assertThat(fido.getColour(), hasItem("Brown"));
        assertThat(fido.getColour(), not(hasItem("White")));


    }
}
