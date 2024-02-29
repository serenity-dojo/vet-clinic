package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;

public class DogBreederEntityBuilder implements WithIBreedable,IwithColourable {
	
	private String name;
	private String breed;
	private String favouriteColour;
	private String optFldFavouriteFood;
	private String optFldFavouriteToy;
	
	public DogBreederEntityBuilder(String name) {
		this.name=name;
		System.out.println("DogBreederEntityBuilder - builders object initialized.");
	}

	public DogBreederEntityBuilder ofDogBreed(String breed) {
		this.breed=breed;
		return this;
	}
	
	public DogEntityImmutableType bornOn(LocalDate localDate) {
		return new DogEntityImmutableType(name, breed, localDate,favouriteColour,optFldFavouriteFood,optFldFavouriteToy);
	}
	
	
	public DogEntity dgEntityBornOn(LocalDate localDate) {
		return new DogEntity(name, breed, localDate,favouriteColour,optFldFavouriteFood,optFldFavouriteToy);
	}
	
	@Override
	public IwithColourable ofBreed(String breed) {
		return new DogBreederEntityBuilder(breed);
	}

	public DogBreederEntityBuilder ofDogColour(String strFavColour) {
		this.favouriteColour=strFavColour;
		return this;
	}


	public DogEntityImmutableType ofColour(String favColour) {
		return new DogEntityImmutableType(favColour);
	}

	public DogBreederEntityBuilder setOptFldFavouriteFood(String strOptFavFood) {
		this.optFldFavouriteFood=strOptFavFood;
		return this;
	}
	
	public DogBreederEntityBuilder setOptFldFavouriteToy(String strOptFavToy) {
		this.optFldFavouriteToy=strOptFavToy;
		return this;
	}
	
	
}
