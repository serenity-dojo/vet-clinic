package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

/**
 * Created by pravyada on 9/9/2016.
 */
public class FoodDispenser {

    private static Map<Breed,Integer> AMOUNT_OF_FOOD = new HashMap<Breed,Integer>();
    private static Map<Breed,PetFood> BRANT_OF_FOOD = new HashMap<Breed,PetFood>();

    static {
        BRANT_OF_FOOD.put(Breed.Cat,PetFood.KittyKat);
        BRANT_OF_FOOD.put(Breed.Dog,PetFood.FidosFood);

        AMOUNT_OF_FOOD.put(Breed.Cat,10);
        AMOUNT_OF_FOOD.put(Breed.Dog,20);
    }

    public Meal prepareMealFor(Pet pet) {
    return new Meal(rightAmountFor(pet),rightBrandFor(pet));
    }

    private PetFood rightBrandFor(Pet pet) {
        return BRANT_OF_FOOD.get(pet.getBreed());
    }

    private double rightAmountFor(Pet pet) {
        return pet.getWeightInKilos()*AMOUNT_OF_FOOD.get(pet.getBreed());
    }
}
