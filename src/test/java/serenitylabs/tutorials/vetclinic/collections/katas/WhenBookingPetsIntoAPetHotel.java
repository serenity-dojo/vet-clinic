package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {

    PetHotel petHotel;

    @Before
    public void setUpHotel() throws Exception {
        petHotel = new PetHotel();
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {

        //WHEN
        Set<Pet> registeredPets = petHotel.getRegisteredPets();

        //THEN
        assertThat(registeredPets.size(), equalTo(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {

        //GIVEN
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getRegisteredPets(),contains(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
       //GIVEN
        Pet fido = Pet.cat().named("Fido");
        Pet lussy = Pet.cat().named("Lussy");

       //WHEN
        petHotel.checkIn(fido);
        petHotel.checkIn(lussy);

        //THEN
        assertThat(petHotel.getRegisteredPets(),contains(fido,lussy));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        //GIVEN
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        petHotel.checkIn(fido);
        petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getRegisteredPets(),contains(fido));

    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {

        //GIVEN
        Pet fido = Pet.cat().named("Fido");
        Pet lussy = Pet.cat().named("Lussy");

        //WHEN
        petHotel.checkIn(lussy);
        petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getRegisteredPets(),contains(fido,lussy));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        //GIVEN
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN
        assertThat(bookingResponse.getPet(),equalTo(fido));
        assertThat(bookingResponse.isConfirmed(),equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        //GIVEN
        APetHotel.with(20).checkIn(petHotel);
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getRegisteredPets(),not(hasItem(fido)));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        //GIVEN
        APetHotel.with(20).checkIn(petHotel);
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN
        assertThat(petHotel.getRegisteredPets(),not(hasItem(fido)));
        assertThat(bookingResponse.isConfirmed(),is(false));

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        //GIVEN
        APetHotel.with(20).checkIn(petHotel);
        Pet fido = Pet.cat().named("Fido");

        //WHEN
        BookingResponse bookingResponse = petHotel.checkIn(fido);

        //THEN
        assertThat(bookingResponse.onWaitingList(),is(true));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        //GIVEN
        APetHotel.with(19).checkIn(petHotel);
        Pet fido = Pet.cat().named("Fido");
        Pet lussy = Pet.cat().named("Lussy");

        //WHEN
        petHotel.checkIn(lussy);
        petHotel.checkIn(fido);
        petHotel.checkOut(lussy);

        //THEN
        assertThat(petHotel.getRegisteredPets(),hasItem(fido));
        assertThat(petHotel.getPetsOnWaitingList(),not(hasItem(fido)));
    }

}
