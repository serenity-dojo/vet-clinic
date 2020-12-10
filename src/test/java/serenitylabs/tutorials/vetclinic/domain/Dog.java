package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class Dog {
    private final LocalDate dateOfBirth;
    private final String name;
    private final String breed;
    private final String colour;
    private final String favouriteFood;
    private final String favouriteToy;

    public Dog(String name, String breed, String colour, String favouriteFood, String favouriteToy, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    public interface WithBreed {
        WithColour ofBreed(String breed);
    }

    public interface WithColour {
        DogBreeder ofColour(String colour);
    }

    public static class DogBreeder implements WithBreed, WithColour {
        private String name;
        private String breed;
        private String colour;
        private String favouriteFood;
        private String favouriteToy;

        public DogBreeder(String name) {
            this.name = name;
        }

        public WithColour ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBreeder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, breed, colour, favouriteFood, favouriteToy, dateOfBirth);
        }

        public DogBreeder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBreeder withFavouriteToy(String favouriteToy) {
            this.favouriteToy = favouriteToy;
            return this;
        }

    }
}