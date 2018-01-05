package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

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

}
