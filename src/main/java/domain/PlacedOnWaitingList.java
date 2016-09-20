package domain;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by pravyada on 9/20/2016.
 */
public class PlacedOnWaitingList extends BookingResponse {
    public PlacedOnWaitingList(Pet pet, int ticketNumber) {
        super(pet,ticketNumber);
    }

    @Override
    public boolean isConfirmed() {
        return false;
    }

    @Override
    public boolean isOnWaiting() {
        return true;
    }
}
