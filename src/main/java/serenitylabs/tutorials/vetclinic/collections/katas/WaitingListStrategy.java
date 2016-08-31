package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

/**
 * Created by aatchoud on 8/29/2016.
 */
public class WaitingListStrategy implements CheckInStrategy {

    private final Collection<Pet> relevanPets;

    public WaitingListStrategy(Collection<Pet> pets) {
        this.relevanPets = pets;
    }

    @Override
    public BookingResponse attemptTocheckIn(Pet pets){
        relevanPets.add(pets);
        return BookingResponse.waitingListFor(pets);
    }
}
