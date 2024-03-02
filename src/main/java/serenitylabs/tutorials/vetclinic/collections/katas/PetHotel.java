package serenitylabs.tutorials.vetclinic.collections.katas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

import serenitylabs.tutorials.vetclinic.collections.exercises.BookingResponse;
import serenitylabs.tutorials.vetclinic.collections.exercises.CheckInStrategy;
import serenitylabs.tutorials.vetclinic.collections.exercises.ConfirmBookingStrategy;
import serenitylabs.tutorials.vetclinic.collections.exercises.HotelAvailability;
import serenitylabs.tutorials.vetclinic.collections.exercises.WaitingListStrategy;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class PetHotel {
	
	public static final int MAXIMUM_PETS = 20;
	private Collection<PetEntity> pets = new TreeSet<>(Comparator.comparing(PetEntity::getName));
    private Queue<PetEntity> waitingList = new LinkedList<>();
    private static final Map<HotelAvailability, CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();
    
    {
        CHECK_IN_STRATEGY.put(HotelAvailability.Available, new ConfirmBookingStrategy(pets));
        CHECK_IN_STRATEGY.put(HotelAvailability.Full, new WaitingListStrategy(waitingList));
    }
    
    public List<PetEntity> getPets() {
        return new ArrayList<>(pets);
    }

    private HotelAvailability currentAvailability() {
        return (pets.size() >= MAXIMUM_PETS) ? HotelAvailability.Full : HotelAvailability.Available;
    }

    public BookingResponse checkIn(PetEntity pet) {
        CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(currentAvailability());
        return checkInStrategy.attemptToCheckIn(pet);
    }

    public Collection<PetEntity> getWaitingList() {
        return new ArrayList<>(waitingList);
    }

	public void checkOut(PetEntity pet) {
		pets.remove(pet);
		if (!waitingList.isEmpty()) {
			checkIn(waitingList.poll());
		}
	}
    
}