package serenitylabs.tutorials.vetclinic.collections.exercises;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class WhenWorkingWithAListOfPetNames {

    @Test
    public void should_add_Fido_to_the_list_of_pets() {
        List<String> names = Lists.newArrayList();

        // TODO
        // Add element in List using add() method
        names.add("Fido");

        assertThat(names, hasItems("Fido"));
    }

    @Test
    public void should_remove_Fido_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix","Fido","Spot");

        // TODO
        // Removing the element from List using by element
        names.remove("Fido");

        assertThat(names, hasItems("Felix","Spot"));
    }

    @Test
    public void should_remove_the_first_pet_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix","Fido","Spot");

        // TODO
        // Removing 1st element from List using index
        names.remove(0);

        assertThat(names, hasItems("Fido","Spot"));
    }

    @Test
    public void should_make_a_list_of_cats_and_dogs() {
        List<String> cats = Lists.newArrayList("Felix","Spot");
        List<String> dogs = Lists.newArrayList("Fido","Rover");


        // TODO
        // Creating list of catsAndDogs, assigning cats List to catsAndDogs
        // Add dogs list in catsAndDogs List
        List<String> catsAndDogs = new ArrayList(cats);
        catsAndDogs.addAll(dogs);

        assertThat(catsAndDogs, hasItems("Felix","Spot","Fido","Rover"));
    }

    @Test
    public void should_put_the_dogs_among_the_cats() {
        List<String> cats = Lists.newArrayList("Felix","Spot");
        List<String> dogs = Lists.newArrayList("Fido","Rover");

        // TODO
        List<String> catsAndDogs = new ArrayList<>();
        // System.out.print( cats.stream().findFirst());
        catsAndDogs.add(cats.get(0));
        catsAndDogs.addAll(dogs);
        catsAndDogs.add(cats.get(1));

        assertThat(catsAndDogs, hasItems("Felix","Fido","Rover","Spot"));
    }

    @Test
    public void should_organise_pets_in_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix","Spot","Fido","Rover");

        // TODO
        // Sort method is used for sorting the list, defaultly used assending order
        Collections.sort(pets);

        assertThat(pets, hasItems("Felix","Fido","Rover","Spot"));
    }

    @Test
    public void should_organise_pets_in_reverse_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix","Spot","Fido","Rover");

        // TODO
        Collections.sort(pets, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        // System.out.print(pets.toString());

        assertThat(pets, hasItems("Spot","Rover","Fido","Felix"));
    }

    @Test
    public void should_organise_pets_by_name_length() {
        List<String> pets = Lists.newArrayList("Felix","Alfred","Spot");

        // TODO
        pets.sort(Comparator.comparing(String::length));

        assertThat(pets, hasItems("Spot","Felix","Alfred"));
    }

}
