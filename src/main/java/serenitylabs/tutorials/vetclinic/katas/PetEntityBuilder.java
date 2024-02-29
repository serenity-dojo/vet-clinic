package serenitylabs.tutorials.vetclinic.katas;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.BreedEnum;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.GenderEnum;

public class PetEntityBuilder {

	private final BreedEnum breed;
	private GenderEnum gender = GenderEnum.Unknown;

	public PetEntityBuilder(BreedEnum breed) {
		this.breed = breed;
	}

	public PetEntity named(String name) {
		return new PetEntity(name, breed, gender);
	}

	public PetEntityBuilder ofGender(GenderEnum gender) {
		this.gender = gender;
		return this;
	}

}