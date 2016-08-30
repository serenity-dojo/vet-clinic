package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.*;

import com.google.common.collect.ImmutableList;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import static java.util.Comparator.comparing;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {
	private final static Random random = new Random();
	private final static List<String> PET_NAMES = ImmutableList.of("Fido", "Felix", "Rover", "Spot");
	private static Set<Pet> pets = new TreeSet<Pet>(comparing(Pet::getName));

    public static PetAdder with(int petCount) {
        return new PetAdder(petCount);
    }

	public static class PetAdder {
		private final int petCount;

		public PetAdder(int petCount) {
			this.petCount = petCount;
		}
		private Pet somePet(int petCount) {
			return new Pet(someName(petCount), someBreed());
		}
		private Breed someBreed() {
			return Breed.values()[random.nextInt(Breed.values().length)];
		}
		private String someName(int petCount) {
			return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
		}

		public PetHotel addMultiplePets() {
			PetHotel hotel = new PetHotel();
			Pet pet;
			for(int i=1;i<=petCount;i++) {
				pet = somePet(i);
				pets.add(pet);
				hotel.checkIn(pet);
			}
			return hotel;
		}
	}





}
