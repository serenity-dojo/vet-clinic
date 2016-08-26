package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheGuestList;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheWaitingList;

import java.util.List;

public class TheGuests {
    public static Question<List<Pet>> registerdInTheHotel() {
        return actor -> actor.usingAbilityTo(ManageTheGuestList.class).getPets();
    }

    public static Question<List<Pet>> onTheWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheWaitingList.class).getPets();
    }
}
