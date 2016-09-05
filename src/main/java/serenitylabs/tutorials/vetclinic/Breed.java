package serenitylabs.tutorials.vetclinic;

import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import static serenitylabs.tutorials.vetclinic.collections.katas.PetFood.FidosFood;
import static serenitylabs.tutorials.vetclinic.collections.katas.PetFood.KittyKat;

public enum Breed {

    Cat(10, KittyKat), Dog(20, FidosFood);
    private int amountIngms;
    private PetFood food;

    Breed(int amountIngms, PetFood food) {
        this.amountIngms = amountIngms;
        this.food = food;
    }

    public int getAmountIngms() {
        return amountIngms;
    }

    public PetFood getFood() {
        return food;
    }
}
