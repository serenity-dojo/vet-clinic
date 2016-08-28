package serenitylabs.tutorials.vetclinic;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import serenitylabs.tutorials.vetclinic.model.FoodDispenser;

import java.util.List;

public class Pet {
    private final String name;
    private final Breed breed;
    private final double weightInKilos;

    private List<Meal> mealsGiven = Lists.newArrayList();

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

        double totalEaten = mealsGiven.stream()
                                      .filter(meal -> meal.getFoodBrand() == FoodDispenser.rightFoodFor(this))
                                      .mapToDouble(meal -> meal.getAmountInGrams())
                                      .sum();

        return (totalEaten >= FoodDispenser.rightAmountOfFoodFor(this));
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
