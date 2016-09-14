package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import java.util.List;

/**
 * Created by kimahale on 9/14/2016.
 */
public class TheGuests {
    public static Question<List<Pet>> registeredInTheHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class)
                .getRegisteredPets();
    }

    public static Question<List<Pet>> onTheWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class)
                .getWaitingPets();
    }
}
