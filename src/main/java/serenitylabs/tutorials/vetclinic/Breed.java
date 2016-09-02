package serenitylabs.tutorials.vetclinic;

public enum Breed {
    Cat("Felis catus"), Dog("Canis lupus familiaris"), Rabbit("Oryctolagus cuniculus"), Fish("Carassius auratus"), Parrot("Psittaciformes");
    private String scientificName;
   
    private Breed(String name){
    	this.scientificName = name ;
    }

	public String scientificName() {
		return scientificName;
	}
}