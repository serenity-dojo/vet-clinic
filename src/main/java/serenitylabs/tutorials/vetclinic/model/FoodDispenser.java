package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.PetFood;


import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vdheer
 * Date: 8/29/16
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodDispenser {

    private static final Map<Breed, Integer> WEIGHT_OF_FOOD = new HashMap<>();
    private static final Map<Breed, PetFood> RIGHT_PET_FOOD = new HashMap<>();

    static{
        WEIGHT_OF_FOOD.put(Breed.Cat, 10);
        WEIGHT_OF_FOOD.put(Breed.Dog, 20);

        RIGHT_PET_FOOD.put(Breed.Cat, PetFood.KittyFood);
        RIGHT_PET_FOOD.put(Breed.Dog, PetFood.FidosFood);
    }

    public Meal prepareMealFor(Pet pet) {
             return new Meal(rightAmountOfFoodInGrams(pet), rightAmountOfPetFood(pet));
    }

    private PetFood rightAmountOfPetFood(Pet pet) {
       return RIGHT_PET_FOOD.get(pet.getBreed());
    }

    private double rightAmountOfFoodInGrams(Pet pet) {
        return pet.getWeightInKilos() * WEIGHT_OF_FOOD.get(pet.getBreed());
    }


}
