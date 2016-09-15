package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Consequence;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by siddharthk on 9/13/2016.
 */
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }


}
