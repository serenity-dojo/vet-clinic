package vetclinic.collections.katas;

import org.junit.Before;
import org.junit.Test;
import vetclinic.Pet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenBookingPetsIntoAPetHotel {
    APetHotel aPetHotel;

    @Before
    public void petHotelSetUp(){
        aPetHotel = APetHotel.with(4).named("Silver Inn");
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(aPetHotel.getPets(),emptyCollectionOf(Pet.class));

    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        aPetHotel.checkIn(tommy);

        //THEN
        assertThat(aPetHotel.getPets(),hasItem(tommy));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {

        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");
        Pet meow=Pet.cat().named("Meow");

        //WHENS
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(meow);

        //THEN
        assertThat(aPetHotel.getPets(),hasItems(tommy,meow));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");
        aPetHotel.checkIn(tommy);

        //WHEN
        aPetHotel.checkIn(tommy);

        //THEN
        assertThat(aPetHotel.getPets(),contains(tommy));
        assertThat(aPetHotel.getPets().size(),is(equalTo(1)));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {

        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");

        //WHEN
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);

        //THEN
        assertThat(aPetHotel.getPets(),contains(bruno,shaggy,tommy));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {

        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        BookingConfirmation confirmation = aPetHotel.checkIn(tommy);

        //THEN
        assertThat(confirmation.isConfirmed(),is(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        //GIVEN HOTEL CAPACITY IS 4
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");
        Pet meow = Pet.cat().named("Meows");
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);
        aPetHotel.checkIn(meow);

        //WHEN
        Pet fido = Pet.dog().named("Fido");
        aPetHotel.checkIn(fido);

        //THEN
        assertThat(aPetHotel.getPets(),not(hasItem(fido)));

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        //GIVEN HOTEL CAPACITY IS 4
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");
        Pet meow = Pet.cat().named("Meows");
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);
        aPetHotel.checkIn(meow);

        //WHEN
        Pet fido = Pet.dog().named("Fido");
        BookingConfirmation bookingConfirmation =aPetHotel.checkIn(fido);

        //THEN
        assertThat(bookingConfirmation.isConfirmed(),is(false));
        assertThat(bookingConfirmation.isWaiting(),is(true));
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        //GIVEN HOTEL CAPACITY IS 4
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");
        Pet meow = Pet.cat().named("Meows");
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);
        aPetHotel.checkIn(meow);

        //WHEN
        Pet fido = Pet.dog().named("Fido");
        BookingResponse response =aPetHotel.checkIn(fido);

        //THEN
        assertThat(aPetHotel.getWaitingPets(),hasItem(fido));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        //GIVEN HOTEL CAPACITY IS 4
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");
        Pet meow = Pet.cat().named("Meows");
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);
        aPetHotel.checkIn(meow);

        Pet fido = Pet.dog().named("Fido");
        BookingResponse response =aPetHotel.checkIn(fido);

        //WHEN
        aPetHotel.checkOut(tommy);

        //THEN
        assertThat(aPetHotel.getWaitingPets(),not(hasItem(fido)));
        assertThat(aPetHotel.getPets(),hasItems(shaggy,bruno,meow,fido));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
        //GIVEN HOTEL CAPACITY IS 4
        Pet tommy = Pet.dog().named("Tommy");
        Pet shaggy = Pet.dog().named("Shaggy");
        Pet bruno = Pet.dog().named("Bruno");
        Pet meow = Pet.cat().named("Meows");
        aPetHotel.checkIn(tommy);
        aPetHotel.checkIn(shaggy);
        aPetHotel.checkIn(bruno);
        aPetHotel.checkIn(meow);

        //WHEN
        Pet fido = Pet.dog().named("Fido");
        aPetHotel.checkIn(fido);

        Pet felix = Pet.dog().named("Fido");
        aPetHotel.checkIn(felix);



        //THEN
        assertThat(aPetHotel.getWaitingPets(),contains(fido,felix));
    }

}
