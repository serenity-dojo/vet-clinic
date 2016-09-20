package vetclinic.collections.katas;

import vetclinic.Pet;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by sapurani on 9/20/2016.
 */
public class ConfirmBookingStrategy implements BookingStratgey {
    private Collection pets= new TreeSet<>(Comparator.comparing(Pet::getName));

    public ConfirmBookingStrategy(Collection<Pet> pets) {
        this.pets=pets;
    }

    public Collection getPets() {
        return pets;
    }

    @Override
    public BookingConfirmation checkIn(Pet pet) {
        pets.add(pet);
        return BookingConfirmation.confirmedFor(pet);
    }
}
