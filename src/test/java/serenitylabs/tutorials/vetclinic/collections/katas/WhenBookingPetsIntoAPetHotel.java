package serenitylabs.tutorials.vetclinic.collections.katas;

import domain.*;
import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {

    private PetHotel petHotel;
    @Before
    public void initialize_pet_hotel(){
        petHotel = new PetHotel();
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {

        assertThat(petHotel.getPets().size(),equalTo(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        petHotel.checkIn(fido);

        assertThat(petHotel.getPets(),contains(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");
        Pet roger = Pet.dog().named("Roger");
        Pet siemens = Pet.cat().named("Siemens");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        petHotel.checkIn(roger);
        petHotel.checkIn(siemens);

        assertThat(petHotel.getPets().size(),equalTo(4));
        assertThat(petHotel.getPets(),containsInAnyOrder(fido,felix,roger,siemens));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        Pet roger = Pet.dog().named("Roger");

        petHotel.checkIn(roger);
        petHotel.checkIn(roger);

        assertThat(petHotel.getPets().size(),equalTo(1));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        //GIVEN
        Pet fido = Pet.dog().named("E");
        Pet felix = Pet.cat().named("Z");
        Pet roger = Pet.dog().named("A");
        Pet siemens = Pet.cat().named("D");

        //WHEN

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        petHotel.checkIn(roger);
        petHotel.checkIn(siemens);

        //THEN
        assertThat(petHotel.getPets(),contains(roger,siemens,fido,felix));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        //GIVEN
        Pet fido = Pet.dog().named("Fido");

        //WHEN

        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN
        assertThat(bookingResponse.isConfirmed(),is(equalTo(true)));

    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(PetHotel.MAX_SIZE).petsCheckedIn();
        //WHEN
        Pet fido = Pet.dog().named("Fido");
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN

        assertThat(bookingResponse.isOnWaiting(),is(equalTo(true)));
        assertThat(petHotel.getPets().size(),equalTo(20));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(19).petsCheckedIn();

        //WHEN
        Pet fido = Pet.dog().named("Fido");
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getPets(),hasItem(fido));
        assertThat(petHotel.getAvailablility(),equalTo(HotelAvailability.Full));
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(PetHotel.MAX_SIZE).petsCheckedIn();
        //WHEN
        Pet fido = Pet.dog().named("Fido");
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN

        assertThat(bookingResponse.isOnWaiting(),is(equalTo(true)));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        //GIVEN
        PetHotel petHotel = APetHotel.with(19).petsCheckedIn();

        Pet roger = Pet.dog().named("Roger");
        Pet siemens = Pet.cat().named("Siemens");

        petHotel.checkIn(roger);
        petHotel.checkIn(siemens);

        //WHEN
        petHotel.checkOut(roger);

        assertThat(petHotel.getPets(),hasItem(siemens));

    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        //GIVEN
        PetHotel petHotel = APetHotel.with(19).petsCheckedIn();

        Pet roger = Pet.dog().named("Roger");
        Pet siemens = Pet.cat().named("Siemens");
        Pet fido = Pet.dog().named("fido");

        petHotel.checkIn(roger);
        petHotel.checkIn(siemens);
        petHotel.checkIn(fido);

        //WHEN
        petHotel.checkOut(roger);

        assertThat(petHotel.getPets(),not(hasItem(fido)));
        assertThat(petHotel.getPets(),hasItem(siemens));

    }

}
