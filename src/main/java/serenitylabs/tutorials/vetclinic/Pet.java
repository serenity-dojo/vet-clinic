package serenitylabs.tutorials.vetclinic;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {
    private final String name;
    private final Breed breed;
    private final double weightInKilos;
    private static Map<Breed,Integer> BREED_SPECIFIC_RATE = new HashMap<Breed,Integer>();
    private List<Meal> mealsGiven = Lists.newArrayList();

    static {
        BREED_SPECIFIC_RATE.put(Breed.Cat,10);
        BREED_SPECIFIC_RATE.put(Breed.Dog,20);
    }
    public Pet(String name, Breed breed, double weightInKilos) {
        this.name = name;
        this.breed = breed;
        this.weightInKilos = weightInKilos;
    }

    public String getName() {
        return name;
    }

    public Breed getBreed() {
        return breed;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public static PetBuilder dog() { return new PetBuilder(Breed.Dog);}
    public static PetBuilder cat() { return new PetBuilder(Breed.Cat);}

    public boolean isWellFed() {
        double totalEaten = 0.0;
        for(Meal meal : mealsGiven) {
            totalEaten = totalEaten + meal.getAmountInGrams();
        }
        return (totalEaten>=getAmountNeeded());
    }

    private double getAmountNeeded() {
        return (getWeightInKilos()* BREED_SPECIFIC_RATE.get(breed));
    }
    public void eat(Meal meal) {
        mealsGiven.add(meal);
    }

    public static class PetBuilder {
        private final Breed breed;
        private double weight;

        public PetBuilder(Breed breed) {
            this.breed = breed;
        }

        public PetBuilder weighing(double weight) {
            this.weight = weight;
            return this;
        }

        public Pet named(String name) {
            return new Pet(name, breed, weight);
        }
    }

    @Override
    public String toString() {
        return "a " + breed + " called " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equal(name, pet.name) && breed == pet.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, breed);
    }
}
