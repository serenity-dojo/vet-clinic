package serenitylabs.tutorials.vetclinic.domain;

public interface WithIBreedable {
	
	IwithColourable ofBreed(String breed);
	
	IwithColourable ofDogBreed(String breed);
	
}