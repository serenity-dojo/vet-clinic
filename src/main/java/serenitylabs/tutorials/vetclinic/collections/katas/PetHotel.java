package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by kimahale on 9/20/2016.
 */
public class PetHotel {

    private Collection<Pet> pets= new TreeSet<>(Comparator.comparing(Pet::getName));
    public static int DEFAULT_MAXIMUM_CAPACITY = 20;

    public List<Pet> getPets() {
        return new ArrayList(pets);
    }

    public BookingResponse checkIn(Pet pet) {

        if (pets.size() <DEFAULT_MAXIMUM_CAPACITY)
           pets.add(pet);
        return new BookingResponse(true);
    }
}
