package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenBookingPetsIntoAPetHotel {


    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        // When
        PetHotel petHotel = new PetHotel();
        // Then
        assertThat(petHotel.getPets(), hasSize(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        // Given
        PetHotel petHotel=new PetHotel();
        Pet fido= Pet.dog().named("Fido");
        //When
        petHotel.checkIn(fido);
        // Then
        assertThat(petHotel.getPets(), hasItems(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {

        // Given
        PetHotel petHotel=new PetHotel();
        Pet fido= Pet.dog().named("Fido");
        Pet felix= Pet.cat().named("Felix");

        //When
        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        // Then
        assertThat(petHotel.getPets(), hasItems(fido, felix));

    }


    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        // Given
        PetHotel petHotel=new PetHotel();
        Pet fido= Pet.dog().named("Fido");
        Pet felix= Pet.cat().named("Felix");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);

        // When
        petHotel.checkIn(fido);
        // Then
        assertThat(petHotel.getPets(), containsInAnyOrder(fido, felix));

    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        // Given
        PetHotel petHotel=new PetHotel();
        Pet fido= Pet.dog().named("Fido");
        Pet felix= Pet.cat().named("Felix");
        Pet tommy= Pet.dog().named("Tommy");


        // When
        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        petHotel.checkIn(tommy);
        // Then
        assertThat(petHotel.getPets(), contains(felix, fido, tommy));


    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        // Given
        PetHotel petHotel=new PetHotel();
        Pet fido= Pet.dog().named("Fido");
        // When
        BookingResponse bookingResponse= petHotel.checkIn(fido);
        // Then
        assertThat(bookingResponse.isConfirmed(), equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        // Given
        PetHotel petHotel=APetHotel.with(20).petsCheckIn();
        Pet fido= Pet.dog().named("Fido");

        // When
        petHotel.checkIn(fido);

        // Then
        assertThat(petHotel.getPets(), hasSize(20));

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

        // Given
        PetHotel petHotel=APetHotel.with(20).petsCheckIn();
        Pet fido= Pet.dog().named("Fido");
        // When
        BookingResponse bookingResponse= petHotel.checkIn(fido);
        // Then
        assertThat(bookingResponse.isConfirmed(), is(false));
        assertThat(bookingResponse.isOnWaitingList(), is(true));


    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        // Given
        PetHotel petHotel=APetHotel.with(20).petsCheckIn();
        Pet fido= Pet.dog().named("Fido");
        // When
         petHotel.checkIn(fido);
        // Then
        assertThat(petHotel.getWaitingList(), hasItem(fido));

    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        // Given
        PetHotel petHotel=APetHotel.with(19).petsCheckIn();
        Pet fido= Pet.dog().named("Fido");
        Pet felix= Pet.cat().named("Felix");
        // Pet roger= Pet.rabbit().named("Roger");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        // petHotel.checkIn(roger);
        petHotel.checkOut(fido);
        // Then
        assertThat(petHotel.getPets(), hasItem(felix));

    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        PetHotel hotel = APetHotel.with(19).petsCheckIn();
        Pet felix = Pet.cat().named("FELIX");
        Pet fido = Pet.dog().named("FIDO");
        Pet roger = Pet.rabbit().named("ROGER");

        hotel.checkIn(felix);
        hotel.checkIn(fido);
        hotel.checkIn(roger);

        //WHEN
        hotel.checkOut(felix);

        //Then
        assertThat(hotel.getPets(), hasItem(fido));
    }

}
