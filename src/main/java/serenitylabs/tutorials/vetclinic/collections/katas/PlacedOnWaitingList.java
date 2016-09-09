package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

public class PlacedOnWaitingList extends BookingResponse {
    public PlacedOnWaitingList(int number, Pet pet) {
        super(number, pet);
    }

    @Override
    public boolean isConfirmed() {
        return false;
    }

    @Override
    public boolean isOnWaitingList() {
        return true;
    }
}
