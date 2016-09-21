package serenitylabs.tutorials.vetclinic.collections.katas;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {


    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        PetHotel hotel = new PetHotel();

        assertThat(hotel.getPets(),hasSize(0));

    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        PetHotel hotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");

        hotel.checkIn(fido);

        assertThat(hotel.getPets(),hasItem(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        PetHotel hotel = new PetHotel();

        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        hotel.checkIn(fido);
        hotel.checkIn(felix);

        assertThat(hotel.getPets(),hasItems(fido,felix));

    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        PetHotel hotel = new PetHotel();

        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        hotel.checkIn(fido);
        hotel.checkIn(felix);
        hotel.checkIn(fido);

        assertThat(hotel.getPets(),containsInAnyOrder(fido,felix));

    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        PetHotel hotel = new PetHotel();

        Pet xelix = Pet.cat().named("Xelix");
        Pet fido = Pet.dog().named("Fido");
        Pet aelix = Pet.cat().named("Aelix");
        Pet felix = Pet.cat().named("Felix");

        hotel.checkIn(xelix);
        hotel.checkIn(fido);
        hotel.checkIn(aelix);
        hotel.checkIn(felix);

        assertThat(hotel.getPets(),contains(aelix,felix,fido,xelix));

    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        PetHotel hotel = new PetHotel();

        Pet fido = Pet.dog().named("Fido");

        hotel.checkIn(fido);

        BookingResponse response = hotel.checkIn(fido);

        assertThat(response.isConfirmed(),equalTo(true));
        assertThat(hotel.getPets(),hasItem(fido));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        PetHotel hotel = APetHotel.with(20).petsCheckedIn();

        Pet fido = Pet.dog().named("Fido");

        hotel.checkIn(fido);

        assertThat(hotel.getPets(),not(hasItem(fido)));

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
