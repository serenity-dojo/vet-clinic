package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.*;

import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.interfaces.CheckInStrategy;

import static java.util.Comparator.comparing;

public class PetHotel {

	private final int MAX_PETS = 20;

	private Set<Pet> pets = new TreeSet<>(comparing(Pet::getName));

	private enum HotelAvailability {Available,Full};
	private Queue<Pet> petsInWaitingList = new LinkedList<>();

	public Set<Pet> getPets() {
		//return new ArrayList<>(pets);
		return pets;
	}

	private static final Map<HotelAvailability,CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();
	{
		CHECK_IN_STRATEGY.put(HotelAvailability.Available,new ConfirmBookingStrategy(pets));
		CHECK_IN_STRATEGY.put(HotelAvailability.Full,new WaitingListStrategy(petsInWaitingList));
	}

	private HotelAvailability getCurrentAvailability(){
		return	(pets.size()>MAX_PETS) ? HotelAvailability.Full:HotelAvailability.Available;
	}


	public BookingResponse checkIn(Pet pet) {
		if(pets.add(pet)) {
			CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(getCurrentAvailability());
			return checkInStrategy.attemptToCheckIn(pet);
		}
	    return null;
	 }

}
