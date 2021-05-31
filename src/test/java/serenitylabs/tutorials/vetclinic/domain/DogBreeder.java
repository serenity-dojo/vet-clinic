package serenitylabs.tutorials.vetclinic.domain;


import com.google.common.collect.ImmutableList;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DogBreeder implements WithBreed, ofColour {
    private String name;
    private String breed;
    private LocalDateTime birthday;
    private List<String> colour;
    private String favouriteFood;
    private String favouriteToy;



    public static DogBreeder aDog() {
        return new DogBreeder();
    }

       public DogBreeder called(String name) {
        this.name = name;
        return this;
    }

      public DogBreeder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }
    public DogBreeder ofColour(String... colour) {
        this.colour = Arrays.asList(colour);
        return this;
    }

    public Dog bornOn(LocalDateTime birthday){
        this.birthday = birthday;
        return new Dog(name,birthday,breed, colour, favouriteFood, favouriteToy);
    }

    public DogBreeder hasFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
        return this;
    }

    public DogBreeder hasFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
        return this;
    }

    public static DogBreeder aLargeDog() {
        return aDog().ofBreed("Labrador");
    }


    public static DogBreeder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aGuardDog() {
        return aDog().ofBreed("Bull Dog");
    }
}