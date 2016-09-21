package serenitylabs.tutorials.vetclinic.collections.katas;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class WhenBookingPetsIntoAPetHotel {
    PetHotel hotel;

    @Before
    public void initialiser(){
        hotel = new PetHotel();
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(hotel.getPets(), hasSize(0));
    }


    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        Pet fido = Pet.dog().named("Fido");

        hotel.checkIn(fido);

      assertThat(hotel.getPets(), hasItem(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        Pet spok = Pet.fish().named("Spok");

        hotel.checkIn(fido);
        hotel.checkIn(spok);

        assertThat(hotel.getPets(), hasItems(fido, spok));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        Pet fido = Pet.dog().named("Fido");
        Pet spok = Pet.fish().named("Spok");

        hotel.checkIn(fido);
        hotel.checkIn(spok);
        hotel.checkIn(fido);

        assertThat(hotel.getPets(), containsInAnyOrder(fido, spok) );
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        Pet spok = Pet.fish().named("Spok");
        Pet felix = Pet.cat().named("Felix");

        hotel.checkIn(fido);
        hotel.checkIn(spok);
        hotel.checkIn(felix);

        assertThat(hotel.getPets(), contains(felix,fido,spok));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        hotel.checkIn(fido);

        BookingResponse response = new BookingResponse(fido, 1);

        assertThat(response.isConfirmed(), is(true));
        assertThat(response.getName(), equalTo(fido));
        assertThat(response.getBookingNumber(), equalTo(1));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        PetHotel hotel = APetHotel.with(19).petsCheckedIn();

        hotel.checkIn(Pet.dog().named("Fido"));
        assertThat(hotel.getPets(), hasSize(20));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
//        PetHotel hotel = APetHotel.with(PetHotel.MAXIMUM_PETS).petsCheckedIn();
//        hotel.checkIn(Pet.dog().named("Fido"));
       // BookingResponse response = new BookingResponse();


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
