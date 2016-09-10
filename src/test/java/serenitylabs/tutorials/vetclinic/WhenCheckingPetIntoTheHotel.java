package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Megha on 06-09-2016.
 */
@RunWith(SerenityRunner.class)
public class WhenCheckingPetIntoTheHotel {

    @Test
    public void when_cheking_pet_into_the_hotel() {
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel hotel = new PetHotel("Silver Inn");

        petra.attemptsTo(
                Checkin.aPet(ginger).into(hotel));


        assertThat(hotel.getPets(), hasItem(ginger));
    }
}
