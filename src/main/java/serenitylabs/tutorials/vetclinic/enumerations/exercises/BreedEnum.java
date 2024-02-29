package serenitylabs.tutorials.vetclinic.enumerations.exercises;

public enum BreedEnum {
	
    Cat("Felis catus"),
    Dog("Canis lupus familiaris"),
    Rabbit("Oryctolagus cuniculus"),
    Fish("Carassius auratus"),
    Parrot("Psittaciformes");

    private final String scientificName;

	BreedEnum(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getScientificName() {
		return scientificName;
	}
    
}