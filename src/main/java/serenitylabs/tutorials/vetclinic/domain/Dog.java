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

    public static WithBreed called(String name) {
        return new DogBuilder(name);
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

    interface WithBreed{
        ofColour ofBreed(String breed);
    }

    interface ofColour{
        DogBuilder ofColour (String colour);
    }


    public static class DogBuilder implements WithBreed  , ofColour{
        private String name;
        private String breed;
        private LocalDateTime birthday;
        private String colour;
        private String favouriteFood;
        private String favouriteToy;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }
        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Dog bornOn(LocalDateTime birthday){
            this.birthday = birthday;
            return new Dog(name,birthday,breed, colour, favouriteFood, favouriteToy);
        }

        public DogBuilder hasFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBuilder hasFavouriteToy(String favouriteToy) {
            this.favouriteToy = favouriteToy;
            return this;
        }
    }
}
