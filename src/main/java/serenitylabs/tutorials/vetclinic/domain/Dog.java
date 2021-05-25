package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final LocalDateTime dateOfBirth;
    private final String breed;
    private final String colour;
    private final String favouriteFood;
    private final String favouriteToy;

    public Dog(String name, LocalDateTime dateOfBirth, String breed, String colour, String favouriteFood, String favouriteToy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.colour = colour;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
    }

      public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    public LocalDateTime getDateOfBirth(){
        return dateOfBirth;
    }
    public String getColour(){ return colour; }
    public String getFavouriteFood() {return favouriteFood;}
    public String getFavouriteToy() {return favouriteToy;}

}
