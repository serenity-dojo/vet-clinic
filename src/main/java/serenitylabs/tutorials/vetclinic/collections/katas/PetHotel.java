package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * Created by Home on 9/21/2016.
 */
public class PetHotel {

    public static final int MAXIMUM_PETS = 20;
    private Collection<Pet> petList = new TreeSet<>(comparing(Pet::getName));

    public List<Pet> getPets() {
        return new ArrayList<>(petList);
    }

    public void checkIn(Pet pet) {
        petList.add(pet);
            }
}
