package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWorkingWithAListOfPetsTests {

	@Test
	public void should_store_a_list_of_pets() {

		List<PetEntity> pets = new ArrayList<>();

		pets.add(PetEntity.cat().named("Felix"));
		pets.add(PetEntity.dog().named("Fido"));

		// TODO: Implement the equals and hashcode methods in the Pet class to make this
		// work
		assertThat(pets, hasItem(PetEntity.dog().named("Fido")));
	System.out.println("\nStep-1 - TC-01 - Executing should_store_a_list_of_pets()");
	}

}