package serenitylabs.tutorials.vetclinic.model;

import com.google.common.base.Objects;

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

    public static PetBuilder dog() { return new PetBuilder(Breed.Dog);}
    public static PetBuilder cat() { return new PetBuilder(Breed.Cat);}
    public static PetBuilder rabbit() { return new PetBuilder(Breed.Rabbit);}
    public static PetBuilder parrot() { return new PetBuilder(Breed.Parrot);}
    public static PetBuilder fish() { return new PetBuilder(Breed.Fish);}

    public static class PetBuilder {
        private final Breed breed;

        public PetBuilder(Breed breed) {
            this.breed = breed;
        }

        public Pet named(String name) {
            return new Pet(name, breed);
        }
    }

    @Override
    public String toString() {
        return "a " + breed + " called " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equal(name, pet.name) && breed == pet.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, breed);
    }
}
