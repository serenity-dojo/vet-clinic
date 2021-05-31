package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Dog {

    private final String name;
    private final LocalDateTime dateOfBirth;
    private final String breed;
    private final List<String> colour;
    private final String favouriteFood;
    private final String favouriteToy;

    public Dog(String name, LocalDateTime dateOfBirth, String breed, List<String> colour, String favouriteFood, String favouriteToy) {
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
    public List<String> getColour(){ return new ArrayList(colour); }
    public String getFavouriteFood() {return favouriteFood;}
    public String getFavouriteToy() {return favouriteToy;}

}
