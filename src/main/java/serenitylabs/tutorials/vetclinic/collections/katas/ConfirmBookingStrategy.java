package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Set;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class ConfirmBookingStrategy implements CheckInStrategy {

    private Set<Pet> registeredPets;

    public ConfirmBookingStrategy(Set<Pet> registeredPets) {

        this.registeredPets = registeredPets;
    }

    @Override
    public BookingResponse checkIn(Pet pet) {
        registeredPets.add(pet);
        return BookingResponse.confirmFor(pet);
    }
}
