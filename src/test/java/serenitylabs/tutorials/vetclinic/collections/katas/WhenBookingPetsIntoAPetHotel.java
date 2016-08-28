package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.APetHotel;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {


    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        // GIVEN
        PetHotel hotel = new PetHotel();

        // THEN
        assertThat(hotel.getPets(), hasSize(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        // GIVEN
        PetHotel hotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");

        // WHEN
        hotel.checkIn(fido);

        // THEN
        assertThat(hotel.getPets(), hasItem(fido));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        // GIVEN
        PetHotel hotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        // WHEN
        hotel.checkIn(fido);
        hotel.checkIn(felix);

        // THEN
        assertThat(hotel.getPets(), hasItems(fido,felix));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        // GIVEN
        PetHotel hotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        // AND
        hotel.checkIn(fido);
        hotel.checkIn(felix);

        // WHEN
        hotel.checkIn(fido);

        // THEN
        assertThat(hotel.getPets(), containsInAnyOrder(fido, felix));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        // GIVEN
        PetHotel hotel = new PetHotel();
        Pet hazel = Pet.cat().named("Hazel");
        Pet rover = Pet.dog().named("Rover");
        Pet felix = Pet.cat().named("Felix");

        // WHEN
        hotel.checkIn(hazel);
        hotel.checkIn(rover);
        hotel.checkIn(felix);

        // THEN
        assertThat(hotel.getPets(), contains(felix, hazel, rover));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        // GIVEN
        PetHotel hotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");

        // WHEN
        BookingResponse confirmation = hotel.checkIn(fido);

        // THEN
        assertThat(confirmation.getNumber(), greaterThan(0));
        assertThat(confirmation.getPet(), equalTo(fido));
        assertThat(confirmation.isConfirmed(), equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        // GIVEN
        PetHotel hotel = APetHotel.with(PetHotel.MAXIMUM_PETS).petsCheckedIn();

        // WHEN
        hotel.checkIn(Pet.dog().named("Lassie"));

        assertThat(hotel.getPets(), hasSize(20));
    }

    /**
     *
     * Refactor checkIn method to return a BookingAcknowledgement interface, which has two methods: isConfirmed()
     * and isOnWaitingList().
     * You will need to complete the APetHotel helper class used in the Given.
     */
    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        // GIVEN
        PetHotel hotel = APetHotel.with(20).petsCheckedIn();

        // WHEN
        BookingResponse response = hotel.checkIn(Pet.dog().named("Lassie"));

        // THEN
        assertThat(response.isConfirmed(), is(false));
        assertThat(response.isOnWaitingList(), is(true));

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        // GIVEN
        PetHotel hotel = APetHotel.with(20).petsCheckedIn();
        Pet lassie = Pet.dog().named("Lassie");

        // WHEN
        hotel.checkIn(lassie);

        // THEN
        assertThat(hotel.getWaitingList(), hasItem(lassie));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        // GIVEN
        PetHotel hotel = APetHotel.with(19).petsCheckedIn();
        Pet fido = Pet.dog().named("Fido");
        Pet lassie = Pet.dog().named("Lassie");

        hotel.checkIn(fido);

        // WHEN
        hotel.checkIn(lassie);
        // AND
        hotel.checkOut(fido);

        // THEN
        assertThat(hotel.getPets(), hasItem(lassie));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
        // GIVEN
        PetHotel hotel = APetHotel.with(19).petsCheckedIn();
        Pet felix = Pet.cat().named("Felix");

        Pet fido = Pet.dog().named("Fido");
        Pet lassie = Pet.dog().named("Lassie");


        hotel.checkIn(felix);

        // WHEN
        hotel.checkIn(fido);
        hotel.checkIn(lassie);
        // AND
        hotel.checkOut(felix);

        // THEN
        assertThat(hotel.getPets(), hasItem(fido));
        assertThat(hotel.getPets(), not(hasItem(lassie)));
    }

}
