package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String name;
    private final String breed;
    private final String colour;

    public Dog(String name, String breed, String colour, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static WithBreed called(String name) {
        return new DogBreeder(name);
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public interface WithBreed {
        DogBreeder ofBreed(String breed);
    }

    public static class DogBreeder implements WithBreed {
        private String name;
        private String breed;
        private String colour;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBreeder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, breed, colour, dateOfBirth);
        }
    }
}
