package serenitylabs.tutorials.vetclinic.collections.katas;
import java.util.Set;
import org.testng.annotations.Test;
import com.google.common.collect.Sets;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class WhenWorkingWithASetOfPetsTests {

	@Test
	public void should_add_Fido_to_the_set_of_pets() {
		Set<String> names = Sets.newHashSet();
		// TODO
		names.add("Fido");

		assertThat(names, contains("Fido"));
	System.out.println("\nStep-1 - TC-01 - Executing should_add_Fido_to_the_set_of_pets()");
	}

	
	@Test
	public void a_set_of_pets_should_not_contain_duplicates() {
		Set<String> names = Sets.newHashSet();
		names.add("Fido");
		names.add("Felix");
		names.add("Fido");

		// TODO
		assertThat(names, containsInAnyOrder("Fido", "Felix"));
	System.out.println("\nStep-2 - TC-02 - Executing a_set_of_pets_should_not_contain_duplicates()");
	}

	
	@Test
	public void adding_several_pets() {
		Set<String> names = Sets.newHashSet("Fido", "Felix");
		names.addAll(Sets.newHashSet("Felix", "Spot"));

		// TODO
		assertThat(names, containsInAnyOrder("Fido", "Felix", "Spot"));
	System.out.println("\nStep-3 - TC-03 - Executing adding_several_pets()");
	}

}