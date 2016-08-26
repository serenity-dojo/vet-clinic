package serenitylabs.tutorials.vetclinic.model;

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
