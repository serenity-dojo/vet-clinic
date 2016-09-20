package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Breed;

/**
 * Created by pawpawar on 9/20/2016.
 */
public class Pet {
    private final String name;
    private final Breed breed;

    public Pet(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }


    public String getName() {
        return name;
    }

    public Breed getBreed() {
        return breed;
    }


    public static class PetBuilder {
        private final Breed breed;

        public PetBuilder(Breed breed) {
            this.breed = breed;
        }

        public Pet named(String name) {
            return new Pet(name, breed);
        }

    }

    public static PetBuilder dog() {
        return new PetBuilder(Breed.Dog);
    }

    public static PetBuilder cat() {
        return new PetBuilder(Breed.Cat);
    }

}
