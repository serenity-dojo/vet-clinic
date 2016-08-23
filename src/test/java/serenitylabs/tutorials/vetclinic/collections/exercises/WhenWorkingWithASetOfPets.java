package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class WhenWorkingWithASetOfPets {

    @Test
    public void should_add_Fido_to_the_set_of_pets() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");
        // TODO
        assertThat(names, is( not ( empty() ) ) );
    }

    @Test
    public void a_set_of_pets_should_not_contain_duplicates() {
        Set<String> names = Sets.newHashSet();

        names.add("Fido");
        names.add("Felix");
        names.add("Fido");

        // TODO
        assertThat(names.size(), is( 2 ) );
    }

    @Test
    public void adding_several_pets() {
        Set<String> names = Sets.newHashSet("Fido","Felix");
        Set<String> originalSet = Sets.newHashSet(names);
        names.addAll(Sets.newHashSet("Felix","Spot"));

        // TODO
        assertThat(names.size(), is( greaterThan( originalSet.size() ) ) );
    }


}
