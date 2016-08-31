package serenitylabs.tutorials.vetclinic;

import com.google.common.base.Objects;

public class Pet {
    private final String name;
    private final Breed breed;
    private Gender gender;


    public Pet(String name, Breed breed, Gender gender) {
        this.name = name;
        this.breed = breed;
        this.gender=gender;
    }

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

    public Gender getGender() {  return gender;   }

    public Pet ofGender(Gender gender) {
        this.gender=gender;
        return  this;
    }


    public static class PetBuilder {
        private final Breed breed;
        private final Gender gender=Gender.Unknown;

        public PetBuilder(Breed breed) {
            this.breed = breed;
        }

        public Pet named(String name) {
            return new Pet(name, breed, gender);
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
