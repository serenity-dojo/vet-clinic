package serenitylabs.tutorials.vetclinic.enumerations.exercises;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenCreatingASimpleEnumTests {

	@Test
	public void the_gender_of_a_pet_should_be_considered_unknown_by_default() {

		// TODO: Add a gender field to the Pet class that takes two possible values:
		// Male, Female and Unknown

		PetEntity unidentifiedTabby = PetEntity.cat().named("Spot");

		assertThat(unidentifiedTabby.getGender(), equalTo(GenderEnum.Unknown));
		System.out.println("\nThis is - TC-01 - the_gender_of_a_pet_should_be_considered_unknown_by_default");
	}

	
	@Test
	public void the_gender_of_a_pet_can_be_provided() {

		// TODO: Refactor the Pet builder method to allow the following construct:

		PetEntity lassie = PetEntity.cat().ofGender(GenderEnum.Male).named("Lassie");

		assertThat(lassie.getGender(), equalTo(GenderEnum.Male));
		System.out.println("\nThis is - TC-02 - the_gender_of_a_pet_can_be_provided");
	}

	
}