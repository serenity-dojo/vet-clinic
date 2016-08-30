package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenBookingPetsIntoAPetHotel {


    APetHotel hotel;

    @Before
    public void initialize() {
        hotel = hotel.aHotel().named("Silver Inn");
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {

        assertThat(hotel.getPets(), emptyCollectionOf(Pet.class));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        Pet pet = Pet.cat().named("Felix");
        hotel.checkIn(pet);
        assertThat(hotel.getPets().size(), equalTo(1));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.dog().named("Felix");
        hotel.checkIn(fido, felix);
        assertThat(hotel.getPets(), hasItems(fido, felix));
    }


    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.dog().named("Felix");
        hotel.checkIn(fido, felix, felix);
        assertThat(hotel.getPets(), containsInAnyOrder(fido, felix));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        Pet felix = Pet.cat().named("Felix");
        Pet helix = Pet.cat().named("Helix");
        Pet bruno = Pet.dog().named("Bruno");
        hotel.checkIn(felix, helix, bruno);
        assertThat(hotel.getPets(), contains(bruno, felix, helix));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        //GIVEN
        Pet felix = Pet.cat().named("Felix");
        Pet helix = Pet.cat().named("Helix");
        Pet bruno = Pet.dog().named("Bruno");
        //WHEN
        BookingResponse response = hotel.checkIn(felix, helix, bruno);
        //THEN
        assertThat(response.isConfirmed(), is(true));

    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        //GIVEN
        Pet felix = Pet.cat().named("Felix");
        Pet helix = Pet.cat().named("Helix");
        Pet bruno = Pet.dog().named("Bruno");
        //WHEN
        BookingResponse response = hotel.aHotel().withCapacity(2).checkIn(felix, helix, bruno);
        //THEN
        assertThat(response.isConfirmed(), is(false));

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
    }

}
