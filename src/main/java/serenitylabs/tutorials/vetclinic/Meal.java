package serenitylabs.tutorials.vetclinic;

import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

public class Meal {
    private final double foodConsumed;
    private final PetFood foodBrand;

    public Meal(double amountInGrams, PetFood footBrand) {
        this.foodConsumed = amountInGrams;
        this.foodBrand = footBrand;
    }

    public double getFoodConsumed() {
        return foodConsumed;
    }

    public PetFood getFoodBrand() {
        return foodBrand;
    }
}
