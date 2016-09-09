package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.ArrayList;
import java.util.List;

public class SpecialisedPetHotel<T> {

    List<T> pets = new ArrayList<>();

    public void checkIn(T pet) {
        pets.add(pet);
    }

    public List<T> getPets() {
        return new ArrayList<>(pets);
    }


}
