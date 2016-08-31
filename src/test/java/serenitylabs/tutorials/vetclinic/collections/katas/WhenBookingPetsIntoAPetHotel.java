package serenitylabs.tutorials.vetclinic.collections.katas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

public class WhenBookingPetsIntoAPetHotel {
PetHotel hotel;
    @Before
    public void initialize_hotel(){
        hotel = new PetHotel();
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        assertThat(hotel.getPets().size(),equalTo(0) );
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        assertThat(hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Felix")).getPet().getName(),containsString("Felix"));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        Pet Fish = Pet.OfBreed(Breed.Fish).named("Fish");
        hotel.checkIn(Fish);
        Pet Dog = Pet.OfBreed(Breed.Dog).named("Dog");
        hotel.checkIn(Dog);
        assertThat(hotel.getPets().size(),equalTo(2));
}

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        Pet Felix = Pet.OfBreed(Breed.Cat).named("Felix");
        hotel.checkIn(Felix);
        hotel.checkIn(Felix);
        assertThat(hotel.getPets().size(),equalTo(1));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        Pet Fish = Pet.OfBreed(Breed.Fish).named("Fish");
        hotel.checkIn(Fish);
        Pet Dog = Pet.OfBreed(Breed.Dog).named("Dog");
        hotel.checkIn(Dog);
        Pet Cat = Pet.OfBreed(Breed.Cat).named("Cat");
        hotel.checkIn(Cat);

        assertThat(hotel.getPets(),contains(Cat,Dog,Fish));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        BookingResponse bookingResponse = hotel.checkIn( Pet.OfBreed(Breed.Fish).named("Fish"));
        assertThat(bookingResponse.isConfirmed(),equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
         
        hotel.checkIn(Pet.OfBreed(Breed.Fish).named("Fish"));
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Dog"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Cat"));
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Parrot"));
        
        assertThat(hotel.getPets(),hasSize(3));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        hotel.checkIn(Pet.OfBreed(Breed.Fish).named("Fish"));
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Dog"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Cat"));

        BookingResponse bookingResponse = hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Parrot"));
        assertThat(bookingResponse.isOnWaitingList(),equalTo(true));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        Pet fish = Pet.OfBreed(Breed.Fish).named("Fish");

        hotel.checkIn(fish);
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Dog"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Cat"));

        Pet aCat = Pet.OfBreed(Breed.Cat).named("Acat");
        hotel.checkIn(aCat);
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Parrot"));
        hotel.checkOut(fish);

        assertThat(hotel.getPets(),hasSize(3));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        Pet fish = Pet.OfBreed(Breed.Fish).named("Fish");

        hotel.checkIn(fish);
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Dog"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Cat"));

        Pet aCat = Pet.OfBreed(Breed.Cat).named("Acat");
        hotel.checkIn(aCat);
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Parrot"));
        hotel.checkOut(fish);

        assertThat(hotel.getPets(),hasItem(aCat));
    }

}
