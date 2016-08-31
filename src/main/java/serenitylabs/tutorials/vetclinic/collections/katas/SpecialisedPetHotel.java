package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravyada on 8/29/2016.
 */
public class SpecialisedPetHotel<T> {
    List<Pet> pets = new ArrayList();

    public void checkIn(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPets(){
        return pets;

    }
}
