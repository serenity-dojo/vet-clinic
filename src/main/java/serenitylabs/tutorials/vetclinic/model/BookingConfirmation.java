package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Pet;

public class BookingConfirmation extends BookingResponse {
    public BookingConfirmation(int number, Pet pet) {
        super(number, pet);
    }

    @Override
    public boolean isConfirmed() {
        return true;
    }

    @Override
    public boolean isOnWaitingList() {
        return false;
    }
}
