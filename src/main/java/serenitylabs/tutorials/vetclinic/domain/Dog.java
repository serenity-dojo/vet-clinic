package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog {

    private String name;
    private LocalDateTime dateOfBirth;
    private String breed;

    public Dog(String name , LocalDateTime dateOfBirth, String breed) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
    }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
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


    public static class DogBreeder {
        private String name;
        private String breed;
        private LocalDateTime birthday;

        public DogBreeder(String name) {
            this.name = name;
        }

        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDateTime birthday){
            this.birthday = birthday;
            return new Dog(name,birthday,breed);
        }

    }
}
