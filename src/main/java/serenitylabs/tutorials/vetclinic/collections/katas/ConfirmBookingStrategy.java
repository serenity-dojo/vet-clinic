package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Collection;

/**
 * Created by aatchoud on 8/29/2016.
 */
public class ConfirmBookingStrategy implements CheckInStrategy {

    private Collection<Pet> pets;

    public ConfirmBookingStrategy(Collection<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public BookingResponse attemptTocheckIn(Pet pet) {
        pets.add(pet);
        return BookingResponse.confirrmedFor(pet);
    }
}
