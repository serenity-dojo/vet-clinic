package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

/**
 * Created by sapurani on 8/31/2016.
 */
public class WaitingListStrategy implements BookingStrategy {
    private final Collection<Pet> pets;

    public WaitingListStrategy(Collection<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public BookingResponse checkIn(Pet pet) {
        pets.add(pet);
        return BookingResponse.waitingListFor(pet);
    }
}
