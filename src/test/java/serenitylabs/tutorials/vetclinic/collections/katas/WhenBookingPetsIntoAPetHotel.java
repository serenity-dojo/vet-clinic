package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;

public class WhenBookingPetsIntoAPetHotel {
    PetHotel hotel;


    @Before
    public void initialize() {
        hotel = PetHotel.named("Westin");
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(hotel.getPets(), hasSize(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        Pet dog = Pet.dog().named("Rocky");

        hotel.checkIn(dog);
        assertThat(hotel.getPets(), hasItem(dog));

    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        Pet mado = Pet.dog().named("Mado");
        Pet micky= Pet.cat().named("Micky");

        hotel.checkIn(mado);
        hotel.checkIn(micky);

        assertThat(hotel.getPets(), hasItems(mado,micky));
    }


    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        Pet mado = Pet.dog().named("Mado");
        Pet micky= Pet.cat().named("Micky");

        hotel.checkIn(mado);
        hotel.checkIn(micky);
        hotel.checkIn(micky);

        assertThat(hotel.getPets(), containsInAnyOrder(mado,micky));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {

        Pet bruno = Pet.dog().named("BRUNO");
        Pet micky = Pet.cat().named("MICKY");
        Pet mado = Pet.dog().named("MADO");

        hotel.checkIn(bruno);
        hotel.checkIn(micky);
        hotel.checkIn(mado);

        assertThat(hotel.getPets(), contains(bruno, mado, micky));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        Pet lucy= Pet.cat().named("LUCY");
        BookingResponse response = hotel.checkIn(lucy);

        assertThat(response.isConfirmed(), equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        Pet rocky = Pet.dog().named("ROCKY");
        PetHotel hotel = PetHotelBuilder.with(30).petsCheckedIn();

        hotel.checkIn(rocky);

        assertThat(hotel.getPets(), hasSize(30));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        Pet bruno= Pet.dog().named("BRUNO");

        PetHotel hotel = PetHotelBuilder.with(30).petsCheckedIn();

        BookingResponse response = hotel.checkIn(bruno);

        assertThat(response.isOnWaitingList(),is(true));
        assertThat(response.isConfirmed(),is(false));
    }

    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        PetHotel hotel = PetHotelBuilder.with(30).petsCheckedIn();
        Pet rocky = Pet.dog().named("ROCKY");
        hotel.checkIn(rocky);

        assertThat(hotel.getWaitingList(), hasItem(rocky));

    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        PetHotel hotel = PetHotelBuilder.with(29).petsCheckedIn();

        Pet micky= Pet.cat().named("MICKY");
        Pet bruno= Pet.dog().named("BRUNO");

        hotel.checkIn(micky);
        hotel.checkIn(bruno);

        hotel.checkOut(micky);

        assertThat(hotel.getPets(), hasItem(bruno));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        PetHotel hotel = PetHotelBuilder.with(29).petsCheckedIn();

        Pet lucy= Pet.cat().named("LUCY");
        Pet brook= Pet.dog().named("BROOK");
        Pet mado= Pet.dog().named("MADO");

        hotel.checkIn(lucy);
        hotel.checkIn(brook);
        hotel.checkIn(mado);

        hotel.checkOut(lucy);

        assertThat(hotel.getPets(), not(hasItem(lucy)));
    }

}
