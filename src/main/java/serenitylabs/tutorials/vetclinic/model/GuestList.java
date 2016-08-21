package serenitylabs.tutorials.vetclinic.model;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class GuestList {

    private Collection<Pet> pets = new TreeSet<>(comparing(Pet::getName));

    public List<Pet> getGuests() {
        return ImmutableList.copyOf(pets);
    }

    public void add(Pet pet) {
        pets.add(pet);
    }

    public int size() {
        return pets.size();
    }

    public boolean remove(Pet pet) {
        return pets.remove(pet);
    }
}
