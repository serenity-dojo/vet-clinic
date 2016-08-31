package serenitylabs.tutorials.vetclinic.collections.exercises;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class WhenWorkingWithAListOfPetNames {

    @Test
    public void should_add_Fido_to_the_list_of_pets() {
        List<String> names = Lists.newArrayList();

        // TODO
        names.add("Fido");

        assertThat(names, contains("Fido"));
    }

    @Test
    public void should_remove_Fido_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix","Fido","Spot");
        // TODO
        names.remove("Fido");
        assertThat(names, contains("Felix","Spot"));
    }

    @Test
    public void should_remove_the_first_pet_from_the_list_of_pets() {
        List<String> names = Lists.newArrayList("Felix","Fido","Spot");

        // TODO
        names.remove(0);

        assertThat(names, contains("Fido","Spot"));
    }

    @Test
    public void should_make_a_list_of_cats_and_dogs() {
        List<String> cats = Lists.newArrayList("Felix","Spot");
        List<String> dogs = Lists.newArrayList("Fido","Rover");

        // TODO
        List<String> catsAndDogs = Lists.newArrayList(cats);
        //cats.addAll(dogs);
        catsAndDogs.addAll(dogs);

        assertThat(catsAndDogs, contains("Felix","Spot","Fido","Rover"));
    }

    @Test
    public void should_put_the_dogs_among_the_cats() {
        List<String> cats = Lists.newArrayList("Felix","Spot");
        List<String> dogs = Lists.newArrayList("Fido","Rover");

        // TODO
        List<String> catsAndDogs = Lists.newArrayList(cats);
        catsAndDogs.addAll(1,dogs);

        assertThat(catsAndDogs, contains("Felix","Fido","Rover","Spot"));
    }

    @Test
        public void should_organise_pets_in_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix","Spot","Fido","Rover");

        // TODO
        pets.sort(Comparator.comparing(String::toString));

        assertThat(pets, contains("Felix","Fido","Rover","Spot"));
    }

    @Test
    public void should_organise_pets_in_reverse_alphabetical_order() {
        List<String> pets = Lists.newArrayList("Felix","Spot","Fido","Rover");

        // TODO
        pets.sort(Comparator.reverseOrder());
        assertThat(pets, contains("Spot","Rover","Fido","Felix"));
    }

    @Test
    public void should_organise_pets_by_name_length() {
        List<String> pets = Lists.newArrayList("Felix","Alfred","Spot");

        // TODO
        pets.sort(Comparator.comparing(String::length));

        assertThat(pets, contains("Spot","Felix","Alfred"));
    }

}
