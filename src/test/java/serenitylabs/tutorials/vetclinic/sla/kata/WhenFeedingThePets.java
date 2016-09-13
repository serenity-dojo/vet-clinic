package serenitylabs.tutorials.vetclinic.sla.kata;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.APetHotel;
import serenitylabs.tutorials.vetclinic.collections.katas.PetHotel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenFeedingThePets {

    @Test
    public void should_feed_each_pet_in_the_hotel() {

        // GIVEN
        PetHotel hotel = APetHotel.with(10).petsCheckedIn();

        // WHEN
        hotel.feedTheGuests();

        // THEN
        hotel.getPets().forEach(
                pet -> assertThat(pet.isWellFed(), equalTo(true))
        );
    }
}
