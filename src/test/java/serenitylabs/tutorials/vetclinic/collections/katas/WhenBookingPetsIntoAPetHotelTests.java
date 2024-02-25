package serenitylabs.tutorials.vetclinic.collections.katas;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class WhenBookingPetsIntoAPetHotelTests {
	
    @Test
	public void the_hotel_should_initially_have_no_pets_booked() {
		// GIVEN
		PetHotel hotel = new PetHotel();
		// THEN
		assertThat(hotel.getPets(), hasSize(0));
	System.out.println("\nStep-1 - part 1 - Execution completed.");
	}

    
    @Test
	public void should_be_able_to_check_a_pet_into_the_hotel() {
		// GIVEN
		PetHotel hotel = new PetHotel();
		PetEntity fido = PetEntity.dog().named("Fido");

		// WHEN
		hotel.checkIn(fido);

		// THEN
		assertThat(hotel.getPets(), hasItem(fido));
	System.out.println("\nStep-2 - part 2 - Execution completed.");
	}

    
    @Test
	public void should_be_able_to_check_in_several_pets() {
		// GIVEN
		PetHotel hotel = new PetHotel();
		PetEntity fido = PetEntity.dog().named("Fido");
		PetEntity felix = PetEntity.cat().named("Felix");

		// WHEN
		hotel.checkIn(fido);
		hotel.checkIn(felix);

		// THEN
		assertThat(hotel.getPets(), hasItems(fido, felix));
	System.out.println("\nStep-3 - part 3 - Execution completed.");
	}

    
    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() {
    	   // GIVEN
        PetHotel hotel = new PetHotel();
        PetEntity fido = PetEntity.dog().named("Fido");
        PetEntity felix = PetEntity.cat().named("Felix");

        // AND
        hotel.checkIn(fido);
        hotel.checkIn(felix);

        // WHEN
        hotel.checkIn(fido);

        // THEN
        assertThat(hotel.getPets(),containsInAnyOrder(fido, felix));
    System.out.println("\nStep-4 - part 4 - Execution completed.");
    }

    
    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() {
    	   // GIVEN
        PetHotel hotel = new PetHotel();
        PetEntity hazel = PetEntity.rabbit().named("Hazel");
        PetEntity rover = PetEntity.dog().named("Rover");
        PetEntity felix = PetEntity.cat().named("Felix");

        // WHEN
        hotel.checkIn(hazel);
        hotel.checkIn(rover);
        hotel.checkIn(felix);

        // THEN
        assertThat(hotel.getPets(),contains(felix, hazel, rover));
    
    System.out.println("\nStep-5 - part 4 - Execution completed.");
    }

    
    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() {
    	   // GIVEN
        PetHotel hotel = new PetHotel();
        PetEntity fido = PetEntity.dog().named("Fido");

        // WHEN
        BookingResponse confirmation = hotel.checkIn(fido);

        // THEN
        assertThat(confirmation.getNumber(), greaterThan(0));
        assertThat(confirmation.getPet(), equalTo(fido));
        assertThat(confirmation.isConfirmed(), equalTo(true));
    System.out.println("\nStep-6 - part 4 - Execution completed.");
    }

    
    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() {
        // GIVEN
        PetHotel hotel = APetHotelEntity.with(PetHotel.MAXIMUM_PETS).petsCheckedIn();

        // WHEN
        hotel.checkIn(PetEntity.dog().named("Lassie"));

        assertThat(hotel.getPets(), hasSize(20));
    System.out.println("\nStep-7 - part 4 - Execution completed.");
    }

    
	/*
	 *
	 * Refactor checkIn method to return a BookingAcknowledgement interface, which
	 * has two methods: isConfirmed() and isOnWaitingList(). You will need to
	 * complete the APetHotel helper class used in the Given.
	 * 
	 */
	@Test
	public void should_notify_owner_that_the_hotel_is_full() {
		 // GIVEN
        PetHotel hotel = APetHotelEntity.with(20).petsCheckedIn();

        // WHEN
        BookingResponse response = hotel.checkIn(PetEntity.dog().named("Lassie"));

        // THEN
        assertThat(response.isConfirmed(),is(false));
        assertThat(response.isOnWaitingList(),is(true));
	System.out.println("\nStep-8 - part 4 - Execution completed.");
	}


	@Test
	public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() {
		// GIVEN
		PetHotel hotel = APetHotelEntity.with(20).petsCheckedIn();
		PetEntity lassie = PetEntity.dog().named("Lassie");

		// WHEN
		hotel.checkIn(lassie);

		// THEN
		assertThat(hotel.getWaitingList(), hasItem(lassie));
	System.out.println("\nStep-9 - part 4 - Execution completed.");
	}

    
    @Test
	public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() {
		// GIVEN
		PetHotel hotel = APetHotelEntity.with(19).petsCheckedIn();
		PetEntity fido = PetEntity.dog().named("Fido");
		PetEntity lassie = PetEntity.dog().named("Lassie");

		hotel.checkIn(fido);

		// WHEN
		hotel.checkIn(lassie);
		// AND
		hotel.checkOut(fido);

		// THEN
		assertThat(hotel.getPets(), hasItem(lassie));
	System.out.println("\nStep-10 - part 4 - Execution completed.");
	}


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() {
    	   // GIVEN
        PetHotel hotel = APetHotelEntity.with(19).petsCheckedIn();
        PetEntity felix = PetEntity.cat().named("Felix");

        PetEntity fido = PetEntity.dog().named("Fido");
        PetEntity lassie = PetEntity.dog().named("Lassie");
        hotel.checkIn(felix);

        // WHEN
        hotel.checkIn(fido);
        hotel.checkIn(lassie);
        // AND
        hotel.checkOut(felix);

        // THEN
        assertThat(hotel.getPets(), hasItem(fido));
        assertThat(hotel.getPets(), not(hasItem(lassie)));	
    System.out.println("\nStep-11 - part 4 - Execution completed.");
    }

}