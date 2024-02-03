package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;

public class DogBreederEntityBuilder {
	
	private String name;
	private String breed;
	private String favouriteColour;
	private String optFldFavouriteFood;
	private String optFldFavouriteToy;
	
	public DogBreederEntityBuilder(String name) {
		this.name=name;
		System.out.println("DogBreederEntityBuilder - builders object initialized.");
	}

	public DogBreederEntityBuilder ofBreed(String breed) {
		this.breed=breed;
		return this;
	}
	
	public DogEntityImmutableType bornOn(LocalDate localDate) {
		return new DogEntityImmutableType(name, breed, localDate,favouriteColour,optFldFavouriteFood,optFldFavouriteToy);
	}
	
}
