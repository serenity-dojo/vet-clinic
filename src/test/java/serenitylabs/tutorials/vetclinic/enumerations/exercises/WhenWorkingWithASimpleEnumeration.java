package serenitylabs.tutorials.vetclinic.enumerations.exercises;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import com.google.common.collect.ImmutableList;

public class WhenWorkingWithASimpleEnumeration {

    @Test
    public void finding_dogs() {
        List<Pet> pets = ImmutableList.of(
                Pet.cat().named("Felix"),
                Pet.dog().named("Rover"),
                Pet.dog().named("Lassie"),
                Pet.rabbit().named("Fiver")
                );
        List<Pet> dogs =   pets.stream().filter(pet -> pet.getBreed().equals(Breed.Dog)).collect(Collectors.toList());
        assertThat(dogs, containsInAnyOrder( Pet.dog().named("Rover"), Pet.dog().named("Lassie")));

    }

    @Test
    public void list_all_known_breeds() {


        List<String> breeds =  Stream.of(Breed.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        assertThat(breeds, contains("Cat", "Dog", "Rabbit", "Fish", "Parrot"));

    }


}
