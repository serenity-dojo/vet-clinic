package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

        List<Pet> dogs = pets.stream().filter(pet -> pet.getBreed()==(Breed.Dog)).collect(Collectors.toList());

        assertThat(dogs, containsInAnyOrder( Pet.dog().named("Rover"), Pet.dog().named("Lassie")));

    }

    @Test
    public void list_all_known_breeds() {

        // TODO: List the names of all the known breeds
    	
        List<String> breeds = Arrays.asList(Breed.values()).stream().map(Breed::toString).collect(Collectors.toList());

        assertThat(breeds, contains("Cat", "Dog", "Rabbit", "Fish", "Parrot"));

    }


}
