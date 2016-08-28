package serenitylabs.tutorials.vetclinic;

import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

public class Meal {
    private final double amountInGrams;
    private final PetFood footBrand;

    public Meal(double amountInGrams, PetFood footBrand) {
        this.amountInGrams = amountInGrams;
        this.footBrand = footBrand;
    }

    public double getAmountInGrams() {
        return amountInGrams;
    }

    public PetFood getFoodBrand() {
        return footBrand;
    }
}
