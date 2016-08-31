package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import java.util.List;

public class TheGuests {
    public static Question<List<Pet>> registeredInTheHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class)
                             .getRegisteredPets();
    }

    public static Question<List<Pet>> onTheWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class)
                             .getWaitingList();
    }
}
