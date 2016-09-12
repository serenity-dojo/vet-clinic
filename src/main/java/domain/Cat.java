package domain;

import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class Cat extends Animal implements NeedsVaccinations {



    private final String name;
    private final String breed;
    private final String color;
    private LocalDate lastVaccinationDate;


    /**
     * @param color
     */
    public Cat(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return String
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    public static CatBuilder called(String name) {
        return new CatBuilder(name);
    }

    @Override
    public String complains() {
        return "Meow";
    }

    @Override
    public void wasVaccinatedOn(LocalDate vaccinationDate) {
        this.lastVaccinationDate = vaccinationDate;
    }

    @Override
    public LocalDate nextVaccinationDate() {
        return lastVaccinationDate.plusYears(1);
    }

    public static class CatBuilder {
        private final String name;
        private String breed;

        public CatBuilder(String name) {
            this.name = name;
        }

        public CatBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Cat ofColor(String color) {
            return new Cat(name, breed, color);
        }

    }
}
