package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.ArrayList;
import java.util.List;

public class SpecialisedPetHotel<T> {
	
	List<T> pets = new ArrayList<>();

	/**
	 * @return the pets
	 */
	public List<T> getPets() {
		return new ArrayList<>(pets);
	}

	/**
	 * @param pets the pets to set
	 */
	public void checkIn(T pets) {
		this.pets.add(pets);
	}
}