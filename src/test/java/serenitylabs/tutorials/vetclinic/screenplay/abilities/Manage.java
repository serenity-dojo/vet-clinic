package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
