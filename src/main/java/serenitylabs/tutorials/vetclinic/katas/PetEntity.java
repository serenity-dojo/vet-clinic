package serenitylabs.tutorials.vetclinic.katas;
import java.util.Objects;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.BreedEnum;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.GenderEnum;

public class PetEntity {

	private final String name;
	private final BreedEnum breed;
	private final GenderEnum gender;

	public PetEntity(String name, BreedEnum breed, GenderEnum gender) {
		this.name = name;
		this.breed = breed;
		this.gender = gender;
	}

	public PetEntity(String name, BreedEnum breed) {
		this(name, breed, GenderEnum.Unknown);
	}

	public String getName() {
		return name;
	}

	public BreedEnum getBreed() {
		return breed;
	}

	public GenderEnum getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "a " + breed + " called " + name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(breed, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PetEntity)) {
			return false;
		}
		PetEntity other = (PetEntity) obj;
		return breed == other.breed && Objects.equals(name, other.name);
	}

	public static PetEntityBuilder dog() {
		return new PetEntityBuilder(BreedEnum.Dog);
	}

	public static PetEntityBuilder cat() {
		return new PetEntityBuilder(BreedEnum.Cat);
	}

	public static PetEntityBuilder rabbit() {
		return new PetEntityBuilder(BreedEnum.Rabbit);
	}

	public static PetEntityBuilder parrot() {
		return new PetEntityBuilder(BreedEnum.Parrot);
	}

	public static PetEntityBuilder fish() {
		return new PetEntityBuilder(BreedEnum.Fish);
	}

}