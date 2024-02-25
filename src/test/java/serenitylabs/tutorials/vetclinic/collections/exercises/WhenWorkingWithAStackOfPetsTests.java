package serenitylabs.tutorials.vetclinic.collections.exercises;
import static org.hamcrest.Matchers.equalTo;
import java.util.Deque;
import java.util.LinkedList;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWorkingWithAStackOfPetsTests {

	@Test
	public void should_store_pets_in_a_stack() {

		Deque<PetEntity> pets = new LinkedList<>();

		pets.push(PetEntity.cat().named("Felix"));
		pets.push(PetEntity.dog().named("Fido"));

		// TODO: Retrieve the last pet put on the list
		PetEntity lastPet = pets.pop();

		assertThat(lastPet.getName(), equalTo("Fido"));
		assertThat(pets.size(), equalTo(1));
	System.out.println("\nStep-1 - TC-01 - Executing should_store_pets_in_a_stack()");
	}

	
	@Test
	public void should_see_the_next_item_in_a_stack() {

		Deque<PetEntity> pets = new LinkedList<>();

		pets.push(PetEntity.cat().named("Felix"));
		pets.push(PetEntity.dog().named("Fido"));

		// TODO: Retrieve the last pet put on the list
		PetEntity lastPet = pets.peek();

		assertThat(lastPet.getName(), equalTo("Fido"));
		assertThat(pets.size(), equalTo(2));
	System.out.println("\nStep-2 - TC-02 - Executing should_see_the_next_item_in_a_stack()");
	}

}