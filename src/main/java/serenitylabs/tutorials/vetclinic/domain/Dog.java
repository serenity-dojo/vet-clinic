package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final String name;
    private final String breed;
    private final String color;
    private final String favouriteFood;
    private final String favouriteToy;
    private final LocalDate dateOfBirth;

    public Dog(String name,
               String breed,
               String color,
               String favouriteFood,
               String favouriteToy,
               LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
        this.dateOfBirth = dateOfBirth;
    }
    //NO setters to provide immutability!
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public String getColor() {
        return color;
    }
    public String getFavouriteFood() {
        return favouriteFood;
    }
    public String getFavouriteToy() {
        return favouriteToy;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}

