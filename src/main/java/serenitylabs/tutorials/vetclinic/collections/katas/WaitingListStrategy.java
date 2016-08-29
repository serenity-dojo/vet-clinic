package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

public class WaitingListStrategy implements CheckInStrategy {
    private final Collection<Pet> relevantPets;

    public WaitingListStrategy(Collection<Pet> pets) {
        this.relevantPets = pets;
    }

    @Override
    public BookingResponse attemptToCheckIn(Pet pet) {
        relevantPets.add(pet);
        return BookingResponse.waitingListFor(pet);
    }

}
