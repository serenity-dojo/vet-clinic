package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;

/**
 * Mutable DogEntity class as its fields values state can be modifyed with the
 * help of setter methods.
 * 
 */

public class DogEntity {

	private String dogName;
	private String dogBreed;
	private LocalDate birthDateTime;
	private String favouriteColour;
	private String optFldFavouriteFood;
	private String optFldFavouriteToy;
	
	DogEntity(String dogName, String dogBreed, LocalDate birthDateTime,String favColour,String strFavFood,String strFavToy) {
		this.dogName = dogName;
		this.dogBreed = dogBreed;
		this.birthDateTime = birthDateTime;
		this.favouriteColour=favColour;
		this.optFldFavouriteFood=strFavFood;
		this.optFldFavouriteToy=strFavToy;
	}

	public DogEntity(){
		System.out.println("Default constructor of Mutable DogEntity class called.");
	}
	
	public String getDogName() {
		return dogName;
	}
	public String getDogBreed() {
		return dogBreed;
	}
	public LocalDate getBirthDateTime() {
		return birthDateTime;
	}
	
	public String getFavouriteColour() {
		return favouriteColour;
	}

	public String getOptFldFavouriteFood() {
		return optFldFavouriteFood;
	}

	public String getOptFldFavouriteToy() {
		return optFldFavouriteToy;
	}

	public static WithIBreedable called(String name)
	{
	return new DogBreederEntityBuilder(name);
	}
	
	public DogEntity dgEntityBornOn(LocalDate localDate) {
		return new DogEntity(dogName, dogBreed, localDate,favouriteColour,optFldFavouriteFood,optFldFavouriteToy);
	}

	public void setDogName(String strDgName) {
		this.dogName=strDgName;
	}

	public void setDogBreed(String strDgBreed) {
		this.dogBreed=strDgBreed;
	}

	public void setBirthDateTime(LocalDate locDateTimeObj) {
		this.birthDateTime=locDateTimeObj;
	}

}