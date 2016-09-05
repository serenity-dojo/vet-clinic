package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.List;

import static serenitylabs.tutorials.vetclinic.model.FoodCalculator.getRightAmountOfFood;
import static serenitylabs.tutorials.vetclinic.model.FoodCalculator.getRightFood;

/**
 * Created by siddharthk on 9/1/2016.
 */
public class HotelCanteen {

    public void feedGuests(List<Pet> pets) {
        pets.forEach(this::feedGuest);
    }

    private void feedGuest(Pet pet) {
        pet.feed(prepareMeal(pet));
    }

    public  Meal prepareMeal(Pet pet) {
        return new Meal(getRightAmountOfFood(pet), getRightFood(pet));
    }

}
