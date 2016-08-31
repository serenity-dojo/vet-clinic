package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {

    private static final Map<Breed, PetFood> BRAND_FOR_BREED = new HashMap<>();
    private static final Map<Breed, Integer> GRAM_PER_KILO_BY_PET = new HashMap<>();

    static {
        BRAND_FOR_BREED.put(Breed.Dog, PetFood.FidosFood);
        BRAND_FOR_BREED.put(Breed.Cat, PetFood.KittyKat);

        GRAM_PER_KILO_BY_PET.put(Breed.Dog, 20);
        GRAM_PER_KILO_BY_PET.put(Breed.Cat, 10);
    }

    public Meal prepareMealfor(Pet pet) {
        return new Meal(rightAmountofFoodFor(pet), rightFoodFor(pet));
    }

    public static PetFood rightFoodFor(Pet pet) {
        return BRAND_FOR_BREED.get(pet.getBreed());
    }


    public static double rightAmountofFoodFor(Pet pet) {
        return pet.getWeightInKilos() * GRAM_PER_KILO_BY_PET.get(pet.getBreed());
    }
}
