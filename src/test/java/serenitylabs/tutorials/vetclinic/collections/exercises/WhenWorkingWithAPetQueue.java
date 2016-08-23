package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.LinkedList;
import java.util.Queue;

public class WhenWorkingWithAPetQueue {

    @Test
    public void should_add_Fido_to_the_end_of_the_queue() {
        Queue<Pet> waitingList = new LinkedList<>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        Pet nextInLine = waitingList.poll();

        // TODO
        assertThat( waitingList.poll(), is( Pet.dog().named("Fido") ) );
    }

    @Test
    public void should_see_who_is_at_the_top_of_the_queue_without_removing_it() {
        Queue<Pet> waitingList = new LinkedList<>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        Pet nextInLine = waitingList.peek();

        // TODO
        assertThat( nextInLine, is(Pet.cat().named("Felix")) );
    }


}
