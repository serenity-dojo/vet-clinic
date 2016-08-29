package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {

	private static String name;
	private Set<Pet> pets = new TreeSet<>(comparing(Pet::getName));
	
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


	public void checkIn(Pet... somePet) {
			pets.addAll(Arrays.asList(somePet));
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
