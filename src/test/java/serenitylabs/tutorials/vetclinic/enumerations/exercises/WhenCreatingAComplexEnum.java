package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;

public class WhenCreatingAComplexEnum {

    /**
     * Add the scientific name to the animal breeds.
     * Cat = "Felis catus"
     * Dog = "Canis lupus familiaris"
     * Rabbit = "Oryctolagus cuniculus"
     * Fish = "Carassius auratus"
     * Parrot = "Psittaciformes"
     */
    @Test
    public void should_be_able_to_find_the_scientific_names_of_an_animal_breed() {

        // TODO: Refactor the Breed enum so that it also stores the scientific name (see comment above).

        // TODO: Uncommet these assertions and make them work
        assertThat(Breed.Cat.scientificNames(), equalTo("Felis catus"));
        assertThat(Breed.Dog.scientificNames(), equalTo("Canis lupus familiaris"));
        assertThat(Breed.Rabbit.scientificNames(), equalTo("Oryctolagus cuniculus"));
    }
}