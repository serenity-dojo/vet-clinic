package serenitylabs.tutorials.vetclinic.enumerations.exercises;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableList;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;

public class WhenWorkingWithASimpleEnumerationTests {

	@Test
	public void finding_dogs() 
	{
		List<PetEntity> pets = ImmutableList.of(PetEntity.cat().named("Felix"), 
				PetEntity.dog().named("Rover"), 
				PetEntity.dog().named("Lassie"),
				PetEntity.rabbit().named("Fiver"));

		// TODO: Extract all the dogs from the pets list

		List<PetEntity> dogs = pets.stream()
				             .filter(pet -> pet.getBreed() == BreedEnum.Dog)
				             .collect(Collectors.toList());

		assertThat(dogs,containsInAnyOrder(PetEntity.dog().named("Rover"), PetEntity.dog().named("Lassie")));
		System.out.println("\nThis is TC-01 - finding_dogs ");
	}

	
	@Test
	public void list_all_known_breeds() 
	{
	// TODO: List the names of all the known breeds
	List<String> breeds = Arrays.asList(BreedEnum.values()).stream().map(BreedEnum::toString)
			                    .collect(Collectors.toList());

	assertThat(breeds, contains("Cat", "Dog", "Rabbit", "Fish", "Parrot"));
	System.out.println("\nThis is TC-02 - list_all_known_breeds ");
	}
	
}