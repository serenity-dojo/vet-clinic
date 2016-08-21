package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

public class WaitingListStrategy implements CheckInStrategy {
    private final WaitingList waitingList;

    public WaitingListStrategy(WaitingList waitingList) {
        this.waitingList = waitingList;
    }

    @Override
    public BookingResponse attemptToCheckIn(Pet pet) {
        waitingList.add(pet);
        return BookingResponse.waitingListFor(pet);
    }

}
