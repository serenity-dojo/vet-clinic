package serenitylabs.tutorials.vetclinic;

public enum Breed {
    Cat("Felis catus"),
    Dog("Canis lupus familiaris"),
    Rabbit("Oryctolagus cuniculus"),
    Fish("Carassius auratus"),
    Parrot("Psittaciformes");

    private final String scientificName;

    Breed(String scientificName) {
        this.scientificName = scientificName;
    }

    public String scientificName() {
        return scientificName;
    }
}