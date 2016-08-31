package serenitylabs.tutorials.vetclinic.collections.katas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;
import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

public class WhenBookingPetsIntoAPetHotel {
PetHotel hotel;
private final int MAX_HOTEL_CAPACITY = 3;
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
        Pet paplet = Pet.OfBreed(Breed.Fish).named("Paplet");
        hotel.checkIn(paplet);
        Pet roger = Pet.OfBreed(Breed.Dog).named("Roger");
        hotel.checkIn(roger);
        
        assertThat(hotel.getPets(),hasItems(paplet,roger));     
}

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        Pet felix = Pet.OfBreed(Breed.Cat).named("Felix");
        hotel.checkIn(felix);
        hotel.checkIn(felix);
        assertThat(hotel.getPets().size(),equalTo(1));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        Pet paplet = Pet.OfBreed(Breed.Fish).named("Paplet");
        hotel.checkIn(paplet);
        Pet roger = Pet.OfBreed(Breed.Dog).named("Roger");
        hotel.checkIn(roger);
        Pet felix = Pet.OfBreed(Breed.Cat).named("Felix");
        hotel.checkIn(felix);

        assertThat(hotel.getPets(),contains(felix,paplet,roger));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        BookingResponse bookingResponse = hotel.checkIn( Pet.OfBreed(Breed.Fish).named("Paplet"));
        assertThat(bookingResponse.isConfirmed(),equalTo(true));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
         
        hotel.checkIn(Pet.OfBreed(Breed.Fish).named("Paplet"));
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Sheru"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Billi"));
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Tota"));
        
        assertThat(hotel.getPets().size(),equalTo(MAX_HOTEL_CAPACITY));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        hotel.checkIn(Pet.OfBreed(Breed.Fish).named("Rohu"));
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Moti"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Shona"));

        BookingResponse bookingResponse = hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Mittu"));
        assertThat(bookingResponse.isOnWaitingList(),equalTo(true));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        Pet rohu = Pet.OfBreed(Breed.Fish).named("Rohu");

        hotel.checkIn(rohu);
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("Sheru"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("Shona"));

        Pet Billi = Pet.OfBreed(Breed.Cat).named("Billi");
        hotel.checkIn(Billi);
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("Mittu"));
        hotel.checkOut(rohu);
        
        assertThat(hotel.getPets().size(),equalTo(MAX_HOTEL_CAPACITY));
        assertThat(hotel.getPets(),hasItem(Billi));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

    	 
        Pet rohuFish = Pet.OfBreed(Breed.Fish).named("A");

        hotel.checkIn(rohuFish);
        hotel.checkIn(Pet.OfBreed(Breed.Dog).named("B"));
        hotel.checkIn(Pet.OfBreed(Breed.Cat).named("C"));

        Pet mona = Pet.OfBreed(Breed.Cat).named("D");
        hotel.checkIn(mona);
        hotel.checkIn(Pet.OfBreed(Breed.Parrot).named("E"));
        hotel.checkOut(rohuFish);

        assertThat(hotel.getPets(),hasItem(mona));
    }

}
