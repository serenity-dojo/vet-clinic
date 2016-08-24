package serenitylabs.tutorials.vetclinic.domain;

/**
 * Created by siddharthk on 8/23/2016.
 */
public class Dog {
    private  String name;
    private String breed;
    private  String color;

    public Dog(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    public static DogBuilder named(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {

        private final String name;
        private String breed;
        private String color;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog ofColor(String color) {
            this.color = color;
            return new Dog(name,breed,color);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
