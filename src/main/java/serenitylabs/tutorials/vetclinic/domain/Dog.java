package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final String name;
    private final String breed;
    private final String colour;
    private final String favouriteFood;
    private final LocalDate dateOfBirth;

    public Dog(String name, String breed, String colour, String favouriteFood, LocalDate dateOfBirth) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
        this.favouriteFood = favouriteFood;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static WithBreed called(String name) {
        return new DogBuilder(name);
    }

    public String getColour() {
        return colour;
    }

    interface WithBreed {
        WithColour ofBreed(String breed);
    }

    interface WithColour {
        DogBuilder ofColour(String colour);
    }

    public static class DogBuilder implements WithBreed, WithColour{
        private final String name;
        private String breed;
        private String colour;
        private String favouriteFood;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, breed, colour, favouriteFood, dateOfBirth);
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public DogBuilder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }
    }
}
