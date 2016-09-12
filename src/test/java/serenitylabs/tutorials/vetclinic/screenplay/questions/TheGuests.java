package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.ManageTheHotel;

import java.util.List;

/**
 * Created by sapurani on 9/12/2016.
 */
public class TheGuests {
    public static Question<List<Pet>> registeredInHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getRegisteredPets();
    }

    public static Question<List<Pet>> onTheWaitintList()  {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getPetsOnWaitingList();
    }

}
