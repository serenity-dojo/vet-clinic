package serenitylabs.tutorials.vetclinic.collections.exercises;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.LinkedList;
import java.util.Queue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenWorkingWithAPetQueue {

    @Test
    public void should_add_Fido_to_the_end_of_the_queue() {
        Queue<Pet> waitingList = new LinkedList<>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        // TODO
        Pet firstPet = waitingList.poll();
        assertThat(waitingList.peek(),equalTo(Pet.dog().named("Fido")));
    }

    @Test
    public void should_see_who_is_at_the_top_of_the_queue_without_removing_it() {
        Queue<Pet> waitingList = new LinkedList<>();

        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        // TODO
        assertThat(waitingList.peek(),equalTo(Pet.cat().named("Felix")));
    }


}
