package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.Manage;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import java.util.List;

/**
 * Created by siddharthk on 9/13/2016.
 */
public class TheGuest {

    public static Question<List<Pet>> registeredInHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getRegisteredPets();

    }

    public static Question<List<Pet>> OnWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getPetsOnWaitingList();
    }
}
