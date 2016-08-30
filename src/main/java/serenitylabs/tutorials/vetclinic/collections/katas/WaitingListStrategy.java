package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.interfaces.CheckInStrategy;

import java.util.Collection;
import java.util.List;

/**
 * Created by pravyada on 8/29/2016.
 */
public class WaitingListStrategy implements CheckInStrategy {
    private final Collection<Pet> relevantPets;

    WaitingListStrategy(Collection<Pet> pets){
        this.relevantPets = pets;
    }

    @Override
    public BookingResponse attemptToCheckIn(Pet pet) {
        relevantPets.add(pet);
        return BookingResponse.waitingFor(pet);
    }
}
