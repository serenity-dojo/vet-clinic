package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by aatchoud on 9/20/2016.
 */
public class PetHotel {

private final int MAXIMUM_PETS_CAPACITY = 20;
    private Set<Pet> pets = new TreeSet<Pet>(Comparator.comparing(Pet::getName));

    public Set<Pet> getPets() {
        return pets;
    }

    public BookingResponse checkIn(Pet pet) {
        if(pets.size()< MAXIMUM_PETS_CAPACITY)
        pets.add(pet);
        return new BookingResponse(true);
    }


}
