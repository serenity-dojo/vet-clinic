package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDateTime;

/**
 * Mutable DogEntity class as its fields values state can be modifyed with the
 * help of setter methods.
 * 
 */

public class DogEntity {

	private String dogName;
	private String dogBreed;
	private LocalDateTime birthDateTime;

	public DogEntity(){
		System.out.println("Default constructor of Mutable DogEntity class called.");
	}
	
	public String getDogName() {
		return dogName;
	}
	public String getDogBreed() {
		return dogBreed;
	}
	public LocalDateTime getBirthDateTime() {
		return birthDateTime;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	public void setBirthDateTime(LocalDateTime birthDateTime) {
		this.birthDateTime = birthDateTime;
	}
	
}