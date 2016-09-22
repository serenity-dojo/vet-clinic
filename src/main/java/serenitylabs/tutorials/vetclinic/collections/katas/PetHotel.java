package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by siddharthk on 9/21/2016.
 */
public class PetHotel {

    private GuestManager guestManager = new GuestManager();
    public Set<Pet> getRegisteredPets() {
        return guestManager.getRegisteredPets();
    }

    public BookingResponse checkIn(Pet pet) {

        return guestManager.checkIn(pet);
    }

    public void checkOut(Pet pet) {
        guestManager.checkOut(pet);
    }

    public Queue<Pet> getPetsOnWaitingList() {
        return guestManager.getPetsOnWaitingList();

    }
}
