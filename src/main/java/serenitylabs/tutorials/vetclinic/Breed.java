package serenitylabs.tutorials.vetclinic;

public enum Breed {
    Cat("Felis catus"),
    	     Dog("Canis lupus familiaris"),
    	     Rabbit ("Oryctolagus cuniculus"),
    	     Fish("Carassius auratus"),
    	     Parrot ("Psittaciformes");
 
    	     private final String scientificNames;
    	     Breed(String scientificNames){
    	    	 this.scientificNames = scientificNames;
    	     }
    	     
    	     public String scientificNames(){
    	    	 return scientificNames;
    	     }
}