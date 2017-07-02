package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final LocalDate dateOfBirth;
    private final String name;
    private final String breed;

    public Dog(String name, String breed, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
    }

    public String getBreed() {
        return breed;
    }

    public static class DogBreeder {
        private String name;
        private String breed    ;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, breed, dateOfBirth);
        }
    }
}
