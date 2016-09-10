package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

/**
 * Created by Megha on 06-09-2016.
 */
@RunWith(SerenityRunner.class)
public class WhenCheckingPetIntoTheHotel {
    Actor petra;
    Pet ginger;
    PetHotel hotel;

    @Before
    public void initialises_actor_pet_and_hotel() {
        petra = Actor.named("Petra the pet owner");
        ginger = Pet.cat().named("Ginger");
        hotel = new PetHotel("Silver Inn");
    }

    @Test
    public void when_cheking_a_pet_into_the_hotel() {

        petra.attemptsTo(
                Checkin.aPet(ginger).into(hotel));

        assertThat(hotel.getPets(), hasItem(ginger));
    }

    @Test
    public void when_checkingout_a_pet_into_the_hotel() {
        petra.attemptsTo(CheckOut.aPet(ginger).from(hotel));

        assertThat(hotel.getPets(), not(hasItem(ginger)));
    }
}
