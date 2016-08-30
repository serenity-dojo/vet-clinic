package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.interfaces.CheckInStrategy;

import java.util.Collection;

/**
 * Created by pravyada on 8/29/2016.
 */
public class ConfirmBookingStrategy implements CheckInStrategy{
private  final Collection<Pet> pets;

    public ConfirmBookingStrategy(Collection<Pet> pets){
        this.pets = pets;
    }
    @Override
    public BookingResponse attemptToCheckIn(Pet pet) {
        pets.add(pet);
        return BookingResponse.confirmedFor(pet);
    }
}
