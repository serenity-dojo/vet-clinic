package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.Pet;

import java.util.List;

public class ManageTheGuestList implements AbilityToListPets {
    private final GuestList guestList;

    public ManageTheGuestList(GuestList guestList) {
        this.guestList = guestList;
    }

    public List<Pet> getPets() {
        return guestList.getGuests();
    }

}
