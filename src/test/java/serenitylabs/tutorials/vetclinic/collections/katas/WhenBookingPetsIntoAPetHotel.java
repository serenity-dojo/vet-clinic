package serenitylabs.tutorials.vetclinic.collections.katas;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Pet;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class WhenBookingPetsIntoAPetHotel {


    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
    	  List<Pet> pets = Lists.newArrayList();

          assertThat(pets, emptyCollectionOf(Pet.class));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
    	List<Pet> pets = Lists.newArrayList();
    	Pet pet = Pet.cat().named("Felix");
    	pets.add(pet);
    	assertThat(pets.size(), equalTo(1));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
    	List<Pet> pets = Lists.newArrayList();
    	Pet cat1 = Pet.cat().named("Felix");
    	Pet cat2=Pet.cat().named("Helix");
    	Pet dog1 = Pet.dog().named("Bruno");
    	Pet dog2=Pet.dog().named("Shaggy");
    	pets.add(cat1);
    	pets.add(cat2);
    	pets.add(dog1);
    	pets.add(dog2);
    	assertThat(pets.size(),greaterThan(1));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
    	Set<Pet> pets = Sets.newHashSet();
    	Pet cat1 = Pet.cat().named("Felix");
    	Pet cat2=Pet.cat().named("Helix");
    	Pet dog1 = Pet.dog().named("Bruno");
    	Pet dog2=Pet.dog().named("Bruno");
    	pets.add(cat1);
    	pets.add(cat2);
    	pets.add(dog1);
    	pets.add(dog2);
    	assertThat(pets.size(), equalTo(3));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
    	List<Pet> pets = Lists.newArrayList();
    	Pet cat1 = Pet.cat().named("Felix");
    	Pet cat2=Pet.cat().named("Helix");
    	Pet dog1 = Pet.dog().named("Bruno");
    	pets.add(cat1);
    	pets.add(cat2);
    	pets.add(dog1);
    	pets.sort((Pet o1, Pet o2)->o1.getName().compareTo(o2.getName()));
    	assertThat(pets, contains("Felix","Helix","Bruno"));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
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
