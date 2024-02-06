package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;

/**
 * Immutable DogEntityImmutableType class as its fields values state can not be
 * modified.
 * 
 */

public class DogEntityImmutableType {

	//marking fields with final soo that its state can not be change.
	private String dogName;
	private String dogBreed;
	private LocalDate dateOfBirth;
	private String favouriteColor;
	private String optFldFavouriteFood;
	private String optFldFavouriteToy;
	
	public static DogEntityImmutableType getImmutableInstance() {
		return new DogEntityImmutableType();
	}
	
	public DogEntityImmutableType(String dogName, String dogBreed, LocalDate birthDateTime) {
		this(dogName, dogBreed, birthDateTime,null,null,null);
		System.out.println("Parameterized constructor of Immutable DogEntityImmutableType class called.");
	}
	
	public DogEntityImmutableType(String dogName, String dogBreed, LocalDate birthDateTime, String favColour,String favFood,String favToys) {
		this.dogName = dogName;
		this.dogBreed = dogBreed;
		this.dateOfBirth = birthDateTime;
		this.favouriteColor = favColour;
		this.optFldFavouriteFood=favFood;
		this.optFldFavouriteToy=favToys;
		System.out.println("Parameterized constructor with new field added.");
	}
	
	public DogEntityImmutableType() {
		
	}
	
	public DogEntityImmutableType(String name) {
		this.dogName=name;
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

	public String getFavouriteColor() {
		return favouriteColor;
	}
	
	public String getOptFldFavouriteFood() {
		return optFldFavouriteFood;
	}

	public String getOptFldFavouriteToy() {
		return optFldFavouriteToy;
	}
	

	public DogEntityImmutableType called(String name) {
		this.dogName=name;
		System.out.println("\nThis methode call is mandatory. called()");
		return this;
	}
	
	public DogEntityImmutableType ofBreed(String breed) {
		System.out.println("\nThis methode call is mandatory. ofBreed()");
		this.dogBreed=breed;
		return this;
	}

	public DogEntityImmutableType ofColour(String favColour) {
		this.favouriteColor=favColour;
		System.out.println("\nThis methode called. ofColour()");
		return this;
	}
	
	
	public DogEntityImmutableType bornOn(LocalDate theFourthOfJuly) {
		System.out.println("\nThis methode call is mandatory. bornOn()");
		return new DogEntityImmutableType(dogName, dogBreed, theFourthOfJuly,favouriteColor,optFldFavouriteFood,optFldFavouriteToy);
	}


	public DogEntityImmutableType setOptFldFavouriteFood(String optFldFavouriteFood) {
		this.optFldFavouriteFood = optFldFavouriteFood;
		System.out.println("\nThis methode call is optional setOptFldFavouriteFood() ");
		return this;
	}

	public DogEntityImmutableType setOptFldFavouriteToy(String optFldFavouriteToy) {
		this.optFldFavouriteToy = optFldFavouriteToy;
		System.out.println("\nThis methode call is optional setOptFldFavouriteToy() ");
		return this;
	}
	
	public static DogEntityImmutableType aLargeDog() {
		return getImmutableInstance().ofBreed("Labrador");
	}
	
	public static DogEntityImmutableType aSmallDog() {
		return getImmutableInstance().ofBreed("Lasa");
	}
	
	public static DogEntityImmutableType aGuardDog() {
		return getImmutableInstance().ofBreed("German Shepherd");
	}
	
}