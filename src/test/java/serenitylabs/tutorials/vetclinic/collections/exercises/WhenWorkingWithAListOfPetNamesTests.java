package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.testng.annotations.Test;
import com.google.common.collect.Lists;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWorkingWithAListOfPetNamesTests {

	@Test
	public void should_add_Fido_to_the_list_of_pets() {
	List<String> names = Lists.newArrayList();
		// TODO
	names.add("Fido");

	assertThat(names, contains("Fido"));
	System.out.println("\nStep-1 - TC-01 - executing - should_add_Fido_to_the_list_of_pets() ");
	}

	
	@Test
	public void should_remove_Fido_from_the_list_of_pets() {
		List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");
		// TODO
		names.remove("Fido");

	assertThat(names, contains("Felix", "Spot"));
	System.out.println("\nStep-2 - TC-02 - executing - should_remove_Fido_from_the_list_of_pets() ");
	}

	
	@Test
	public void should_remove_the_first_pet_from_the_list_of_pets() {
	List<String> names = Lists.newArrayList("Felix", "Fido", "Spot");

		// TODO
	names.remove(0);

	assertThat(names, contains("Fido", "Spot"));
	System.out.println("\nStep-3 - TC-03 - executing - should_remove_the_first_pet_from_the_list_of_pets() ");
	}

	
	@Test
	public void should_make_a_list_of_cats_and_dogs() {
		List<String> cats = Lists.newArrayList("Felix", "Spot");
		List<String> dogs = Lists.newArrayList("Fido", "Rover");

		// TODO
		List<String> catsAndDogs = new ArrayList<String>(cats);
		catsAndDogs.addAll(dogs);

		assertThat(catsAndDogs, contains("Felix", "Spot", "Fido", "Rover"));
	System.out.println("\nStep-4 - TC-04 - executing - should_make_a_list_of_cats_and_dogs() ");
	}

	
	@Test
	public void should_put_the_dogs_among_the_cats() {
		List<String> cats = Lists.newArrayList("Felix", "Spot");
		List<String> dogs = Lists.newArrayList("Fido", "Rover");

		// TODO
		List<String> catsAndDogs = new ArrayList<String>(cats);
		catsAndDogs.addAll(1, dogs);

		assertThat(catsAndDogs, contains("Felix", "Fido", "Rover", "Spot"));
	System.out.println("\nStep-5 - TC-05 - executing - should_put_the_dogs_among_the_cats() ");
	}

	
	@Test
	public void should_organise_pets_in_alphabetical_order() {
		List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

		// TODO
		pets.sort(Comparator.naturalOrder());

		assertThat(pets, contains("Felix", "Fido", "Rover", "Spot"));
	System.out.println("\nStep-6 - TC-06 - executing - should_organise_pets_in_alphabetical_order() ");
	}

	
	@Test
	public void should_organise_pets_in_reverse_alphabetical_order() {
		List<String> pets = Lists.newArrayList("Felix", "Spot", "Fido", "Rover");

		// TODO
		pets.sort(Comparator.reverseOrder());

		assertThat(pets, hasItems("Spot", "Rover", "Fido", "Felix"));
	System.out.println("\nStep-7 - TC-07 - executing - should_organise_pets_in_reverse_alphabetical_order() ");
	}

	
	@Test
	public void should_organise_pets_by_name_length() {
		List<String> pets = Lists.newArrayList("Felix", "Alfred", "Spot");

		// TODO
		pets.sort(Comparator.comparing(String::length));

		assertThat(pets, contains("Spot", "Felix", "Alfred"));
	System.out.println("\nStep-8 - TC-08 - executing - should_organise_pets_by_name_length() ");
	}

	
}