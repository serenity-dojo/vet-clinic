package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by sapurani on 9/12/2016.
 */
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
