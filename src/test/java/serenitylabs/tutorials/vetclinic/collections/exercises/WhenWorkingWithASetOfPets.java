package serenitylabs.tutorials.vetclinic.collections.exercises;

 

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class WhenWorkingWithASetOfPets {

    @Test
    public void should_add_Fido_to_the_set_of_pets() {
        Set<String> names = Sets.newHashSet();
        names.add("Fido");
        // TODO
        
        assertThat(names,hasItem("Fido"));
    }

    @Test
    public void a_set_of_pets_should_not_contain_duplicates() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");
        names.add("Felix");
        names.add("Fido");

        // TODO
        assertEquals(2,names.size());
        assertThat(names, hasItems("Fido","Felix"));
    }

    @Test
    public void adding_several_pets() {
        Set<String> names = Sets.newHashSet("Fido","Felix");

        names.addAll(Sets.newHashSet("Felix","Spot"));

        // TODO
        assertEquals(3,names.size());
    }


}
