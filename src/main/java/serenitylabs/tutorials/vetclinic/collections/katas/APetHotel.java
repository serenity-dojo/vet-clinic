package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {
	

	private String name;
	private List<Pet> pets = new ArrayList<>() ;
	
	public String getName() {
		return name;
	}

	public List<Pet> getPets() {
		return pets;
	}
	
    public APetHotel(String name) {
         this.name = name;
    }

	public APetHotel(List<Pet> pets2) {
		pets.addAll(pets2);
	}

	public static PetAdder with(int petCount) {
        return new PetAdder(petCount);
    }

	
    public static AHotelBuilder aHotel( ) {
        return new AHotelBuilder();
    }
    public static class PetAdder {
        private final int petCount;

        public PetAdder(int petCount) {

            this.petCount = petCount;
        }
        
        private Pet somePet(int petCount) {
            return new Pet(someName(petCount), someBreed());
        }

        private final static Random random = new Random();

        private Breed someBreed() {
            return Breed.values()[ random.nextInt(Breed.values().length) ];
        }

        private final static List<String> PET_NAMES = ImmutableList.of("Fido","Felix","Rover","Spot");

        private String someName(int petCount) {
            return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
        }
    }
    
    public static class AHotelBuilder {
    	public APetHotel named( String name ){
    		return new APetHotel( name );
    	}
    	
    	public static APetHotel checkIn(List<Pet> pets) {
            return new APetHotel(pets);
        }
    	
    }
}
