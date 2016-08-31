package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Gender;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class WhenCreatingASimpleEnum {

    @Test
    public void the_gender_of_a_pet_should_be_considered_unknown_by_default() {

        // TODO: Add a gender field to the Pet class that takes two possible values: Male, Female and Unknown

        Pet unidentifiedTabby = Pet.dog().named("Rover");

        assertThat(unidentifiedTabby.getGender(), equalTo(Gender.Unknown));

        // TODO: assertThat(unidentifiedTabby.getGender(), equalTo(Gender.Unknown));

    }

    @Test
    public void the_gender_of_a_pet_can_be_provided() {

        // TODO: Refactor the Pet builder method to allow the following construct:
        Pet lassie = Pet.cat().named("Lassie").ofGender(Gender.Male);

        // TODO:
        assertThat(lassie.getGender(), equalTo(Gender.Male));

    }


}
