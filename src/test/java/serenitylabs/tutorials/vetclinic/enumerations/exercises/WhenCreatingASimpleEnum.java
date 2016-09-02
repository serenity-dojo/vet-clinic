package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Gender;
import serenitylabs.tutorials.vetclinic.Pet;

public class WhenCreatingASimpleEnum {

    @Test
    public void the_gender_of_a_pet_should_be_considered_unknown_by_default() {

        // TODO: Add a gender field to the Pet class that takes two possible values: Male, Female and Unknown

    	Pet unidentifiedTabby = Pet.dog().named("Tabby");
        assertThat(unidentifiedTabby.getGender(), equalTo(Gender.UNKNOWN));

    }

    @Test
    public void the_gender_of_a_pet_can_be_provided() {

        // TODO: Refactor the Pet builder method to allow the following construct:

        Pet lassie = Pet.dog().named("lassie").having(Gender.MALE);

        assertThat(lassie.getGender(), equalTo(Gender.MALE));

    }


}
