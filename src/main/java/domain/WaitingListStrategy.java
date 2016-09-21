package domain;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

/**
 * Created by pravyada on 9/20/2016.
 */
public class WaitingListStrategy implements CheckInStrategy {

    Collection<Pet> petsOnWaiting;

    WaitingListStrategy(Collection<Pet> pets){
        this.petsOnWaiting = pets;
    }

    @Override
    public BookingResponse doCheckIn(Pet pet) {
        petsOnWaiting.add(pet);
        return BookingResponse.waitingListFor(pet);
    }
}
