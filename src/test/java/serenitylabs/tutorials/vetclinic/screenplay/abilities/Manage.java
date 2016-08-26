package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.model.WaitingList;

public class Manage {
    public static ManageTheGuestList the(GuestList guestList) {
        return new ManageTheGuestList(guestList);
    }

    public static ManageTheWaitingList the(WaitingList waitingList) {
        return new ManageTheWaitingList(waitingList);
    }

    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
