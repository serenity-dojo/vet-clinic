package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class WhenWeCreateANewDog {
    private static final LocalDate THE_FIFTH_OF_JUNE_2023 = LocalDate.of(2023, 06, 05);

    @Test
    public void a_new_dog_should_have_a_name_breed_color_and_date_of_birth() {
        Dog chappy = DogBreeder.aLargeDog()//aLargeDog() is going to be a static entry method point for DogBreeder builder
                .called("Chappy")//mandatory
                //.ofBreed("Collie") //mandatory, returned by aLargeDog() method; we might not care about the breed,
                                     // we just create a Dog chappy with some pre-populated fields, they might be hardcoded
                .ofColor("white") //mandatory
                .bornOn(THE_FIFTH_OF_JUNE_2023);//mandatory

        assertEquals("Chappy", chappy.getName());
        assertEquals("Collie", chappy.getBreed());
        assertEquals("white", chappy.getColor());
        assertEquals(THE_FIFTH_OF_JUNE_2023, chappy.getDateOfBirth());
    }
    @Test
    public void it_should_have_an_optional_favourite_food() {
        Dog buddy = DogBreeder.aSmallDog()
                .called("Buddy") //mandatory
                //.ofBreed("Poodle")   //mandatory, returned by aLargeDog() method
                .ofColor("black")  //mandatory
                .withFavouriteFood("cucumber")//optional
                .bornOn(THE_FIFTH_OF_JUNE_2023); //mandatory

        assertEquals("Buddy", buddy.getName());
        assertEquals("Poodle", buddy.getBreed());
        assertEquals("black", buddy.getColor());
        assertEquals("cucumber", buddy.getFavouriteFood());
        assertEquals(THE_FIFTH_OF_JUNE_2023, buddy.getDateOfBirth());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_toy() {
        Dog buddy = DogBreeder.aGuardDog()
                .called("Fido") //mandatory
                //.ofBreed("Labrador")   //mandatory
                .ofColor("black")  //mandatory
                .withFavouriteToy("doll")//optional
                .bornOn(THE_FIFTH_OF_JUNE_2023); //mandatory

        assertEquals("Fido", buddy.getName());
        assertEquals("Shepherd", buddy.getBreed());
        assertEquals("black", buddy.getColor());
        assertEquals("doll", buddy.getFavouriteToy());
        assertEquals(THE_FIFTH_OF_JUNE_2023, buddy.getDateOfBirth());
    }
}
