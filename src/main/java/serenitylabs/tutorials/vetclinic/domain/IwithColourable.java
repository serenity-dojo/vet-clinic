package serenitylabs.tutorials.vetclinic.domain;

public interface IwithColourable {

	DogEntityImmutableType ofColour(String favColour);
	
	DogBreederEntityBuilder ofDogColour(String strFavColour);
}
