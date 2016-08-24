package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {

	private static String name;
	private Set<Pet> pets = new HashSet<>();
	
	public String getName() {
		return name;
	}

	public Set<Pet> getPets() {
		return pets;
	}
	
    public APetHotel(String name) {
         this.name = name;
    }

	

	public APetHotel( Set<Pet> pets2 ) {
		pets.addAll( pets2 );
	}

	public APetHotel checkIN(Set<Pet> pets2) {
		return new APetHotel(pets2);
	}


	public void sort() {
		pets = pets.stream().sorted((Pet o1, Pet o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toSet());
	}

    public static AHotelBuilder aHotel( ) {
        return new AHotelBuilder();
    }
    
    public static class AHotelBuilder {

		public APetHotel named( String name ){
    		return new APetHotel( name );
    	}
    	
    }
}
