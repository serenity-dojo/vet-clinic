package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

//DogBreeder class after it implements interface WithBreed should implement all the methods from this class
//Otherwise - the Interface should be used in order to make the method mandatory
public class DogBreeder implements WithBreed, WithColor {
        private String name;
        private String breed;
        private String color;
        private String favouriteFood;
        private String favouriteToy;

        public static DogBreeder aDog() {
            return new DogBreeder();
        }
    public static DogBreeder aLargeDog() {
            return aDog().ofBreed("Collie");
    }

    public static DogBreeder aSmallDog() {
            return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aGuardDog() {
            return aDog().ofBreed("Shepherd");
    }
    public DogBreeder called(String name) {
            this.name = name;
            return this;
    }
        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }
        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, breed, color, favouriteFood, favouriteToy, dateOfBirth);
        }
        public DogBreeder ofColor(String color) {
            this.color = color;
            return this;
        }
        //If the field is optional, it should be just a standard builder method
        public DogBreeder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }
        public DogBreeder withFavouriteToy(String favouriteToy) {
            this.favouriteToy = favouriteToy;
            return this;
        }
    }