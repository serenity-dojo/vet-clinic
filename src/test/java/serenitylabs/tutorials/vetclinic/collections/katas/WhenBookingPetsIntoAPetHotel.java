package serenitylabs.tutorials.vetclinic.collections.katas;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {
     @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        PetHotel petHotel = new PetHotel();

        assertThat(petHotel.getPets(),hasSize(0));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");

        petHotel.checkIn(fido);

        assertThat(petHotel.getPets(), hasItem(fido));

    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);

        assertThat(petHotel.getPets(),hasItems(fido,felix));

    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        petHotel.checkIn(fido);

        assertThat(petHotel.getPets(), containsInAnyOrder(fido, felix));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");
        Pet star = Pet.fish().named("Star");

        petHotel.checkIn(fido);
        petHotel.checkIn(felix);
        petHotel.checkIn(star);

        assertThat(petHotel.getPets(), contains(felix,fido,star) );

    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");

        BookingResponse confirmation = petHotel.checkIn(fido);

        assertThat(confirmation.getNumber(),greaterThan(0));
        assertThat(confirmation.getPet(),equalTo(fido));
        assertThat(confirmation.isConfirmed(),equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        PetHotel hotel = APetHotel.with(PetHotel.MAXIMUM_PETS).petsCheckedIn();

        hotel.checkIn(Pet.dog().named("Lassie"));

        assertThat(hotel.getPets(),hasSize(20));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        PetHotel hotel = APetHotel.with(20).petsCheckedIn();

        BookingResponse response = hotel.checkIn(Pet.dog().named("Lassie"));

        assertThat(response.isConfirmed(),is(false));
        assertThat(response.isOnWaitingList(),is(true));

    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        PetHotel hotel = APetHotel.with(20).petsCheckedIn();

        Pet lassie = Pet.dog().named("Lassie");

        hotel.checkIn(lassie);

        assertThat(hotel.getWaitingList(),hasItem(lassie));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        PetHotel hotel = APetHotel.with(19).petsCheckedIn();

        Pet lassie = Pet.dog().named("Lassie");
        Pet fido = Pet.dog().named("Fido");

        hotel.checkIn(fido);
        hotel.checkIn(lassie);

        hotel.checkOut(fido);

        assertThat(hotel.getPets(),hasItem(lassie));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        PetHotel hotel = APetHotel.with(19).petsCheckedIn();

        Pet lassie = Pet.dog().named("Lassie");
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        hotel.checkIn(fido);
        hotel.checkIn(felix);
        hotel.checkIn(lassie);

        hotel.checkOut(fido);

        assertThat(hotel.getPets(),hasItem(felix));
        assertThat(hotel.getPets(),not(hasItem(lassie)));
    }

}
