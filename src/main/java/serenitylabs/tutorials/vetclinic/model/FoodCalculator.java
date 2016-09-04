package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

/**
 * Created by siddharthk on 9/4/2016.
 */
public class FoodCalculator {

    public static PetFood getRightFood(Pet pet) {
        return pet.getBreed().getFood();
    }

    public static double getRightAmountOfFood(Pet pet) {
        return pet.getBreed().getAmountIngms() * pet.getWeightInKilos();
    }

}
