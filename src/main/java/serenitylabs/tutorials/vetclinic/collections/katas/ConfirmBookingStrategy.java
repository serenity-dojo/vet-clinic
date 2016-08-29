package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

public class ConfirmBookingStrategy implements CheckInStrategy {
    private final Collection<Pet> pets;

    public ConfirmBookingStrategy(Collection<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public BookingResponse attemptToCheckIn(Pet pet) {
        pets.add(pet);
        return BookingResponse.confirmedFor(pet);
    }
}
