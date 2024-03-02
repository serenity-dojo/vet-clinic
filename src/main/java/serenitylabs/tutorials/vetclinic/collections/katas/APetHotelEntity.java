package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * A utility class to generate pet hotels with pets already booked
 * 
 */

public class APetHotelEntity {
	
	public static PetAdderEntityBuilder with(int petCount) {
        return new PetAdderEntityBuilder(petCount);
    }

}