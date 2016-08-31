package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.*;

import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.interfaces.CheckInStrategy;

import static java.util.Comparator.comparing;

public class PetHotel {

	private final int MAX_PETS = 3;

	private static Collection<Pet> pets = new TreeSet<>(comparing(Pet::getName));


	private enum HotelAvailability {Available,Full};
	private static Queue<Pet> petsInWaitingList = new LinkedList<>();

	public List<Pet> getPets() {
		return new ArrayList<>(pets);
	}

	private static final Map<HotelAvailability,CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();
	static{
		CHECK_IN_STRATEGY.put(HotelAvailability.Available,new ConfirmBookingStrategy(pets));
		CHECK_IN_STRATEGY.put(HotelAvailability.Full,new WaitingListStrategy(petsInWaitingList));
	}

	private HotelAvailability getCurrentAvailability(){
		return	(pets.size()>=MAX_PETS) ? HotelAvailability.Full:HotelAvailability.Available;
	}


	public BookingResponse checkIn(Pet pet) {
		CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(getCurrentAvailability());
		return checkInStrategy.attemptToCheckIn(pet);
	 }

	public void checkOut(Pet pet) {
		pets.remove(pet);
		if (!petsInWaitingList.isEmpty()) {
			checkIn(petsInWaitingList.poll());
		}
	}

}
