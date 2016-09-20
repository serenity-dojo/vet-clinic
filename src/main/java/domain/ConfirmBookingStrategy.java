package domain;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by pravyada on 9/20/2016.
 */
public class ConfirmBookingStrategy implements CheckInStrategy {

    private Collection<Pet> petList;


    public ConfirmBookingStrategy(Collection<Pet> petList) {
        this.petList = petList;
    }


    @Override
    public BookingResponse doCheckIn(Pet pet) {
        petList.add(pet);
        return BookingResponse.confirmedFor(pet);
    }
}
