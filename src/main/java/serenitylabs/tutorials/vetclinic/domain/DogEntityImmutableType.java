package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;

/**
 * Immutable DogEntityImmutableType class as its fields values state can not be
 * modified.
 * 
 */

public class DogEntityImmutableType {

	//marking fields with final soo that its state can not be change.
	private final String dogName;
	private final String dogBreed;
	private final LocalDate dateOfBirth;
	private final String favouriteFood;
	
	public DogEntityImmutableType(String dogName, String dogBreed, LocalDate birthDateTime) {
		this(dogName, dogBreed, birthDateTime,null);
		System.out.println("Parameterized constructor of Immutable DogEntityImmutableType class called.");
	}
	
	public DogEntityImmutableType(String dogName, String dogBreed, LocalDate birthDateTime, String favouriteFood) {
		this.dogName = dogName;
		this.dogBreed = dogBreed;
		this.dateOfBirth = birthDateTime;
		this.favouriteFood = favouriteFood;
		System.out.println("Parameterized constructor with new field added.");
	}
	
	public String getDogName() {
		return dogName;
	}
	public String getDogBreed() {
		return dogBreed;
	}
	public LocalDate getBirthDate() {
		return dateOfBirth;
	}

	public String getFavouriteFood() {
		return favouriteFood;
	}
	
	public static DogBreederEntityBuilder called(String name) {
		return new DogBreederEntityBuilder(name);
	}
	
}