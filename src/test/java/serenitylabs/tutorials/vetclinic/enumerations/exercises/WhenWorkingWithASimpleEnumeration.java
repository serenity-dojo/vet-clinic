package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class WhenWorkingWithASimpleEnumeration {

    @Test
    public void finding_dogs() {
        List<Pet> pets = ImmutableList.of(
                Pet.cat().named("Felix"),
                Pet.dog().named("Rover"),
                Pet.dog().named("Lassie"),
                Pet.rabbit().named("Fiver")
                );

        // TODO: Extract all the dogs from the pets list

        List<Pet> dogs = null;

        assertThat(dogs, containsInAnyOrder( Pet.dog().named("Rover"), Pet.dog().named("Lassie")));

    }

    @Test
    public void list_all_known_breeds() {

        // TODO: List the names of all the known breeds

        List<String> breeds = null;
        assertThat(breeds, contains("Cat", "Dog", "Rabbit", "Fish", "Parrot"));

    }


}
