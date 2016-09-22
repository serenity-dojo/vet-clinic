package serenitylabs.tutorials.vetclinic.collections.katas;

import com.google.common.collect.*;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class GuestManager {

    public static final int MAXIMUM_PETS_HOTEL_CAPACITY = 20;

    private  Set<Pet> registeredPets = new TreeSet<>(Comparator.comparing(Pet::getName));
    private  Queue<Pet> petsOnWaitingList = new LinkedList();

    private  HotelAvailability checkAvailability(){
        return registeredPets.size() < MAXIMUM_PETS_HOTEL_CAPACITY ? HotelAvailability.AVAILABLE
                : HotelAvailability.FULL;
    }

    private  final Map<HotelAvailability, CheckInStrategy> CHECK_IN_PROCEDURE = new HashMap<>();
     {
        CHECK_IN_PROCEDURE.put(HotelAvailability.AVAILABLE, new ConfirmBookingStrategy(registeredPets));
        CHECK_IN_PROCEDURE.put(HotelAvailability.FULL, new WaitingListStrategy(petsOnWaitingList));
    }

    public  BookingResponse checkIn(Pet pet) {

        HotelAvailability hotelAvailability = checkAvailability();
        CheckInStrategy checkInStrategy = CHECK_IN_PROCEDURE.get(checkAvailability());
        return checkInStrategy.checkIn(pet);
    }

    public  Set<Pet> getRegisteredPets() {
        return ImmutableSet.copyOf(registeredPets);
    }


    public  void checkOut(Pet pet) {
           registeredPets.remove(pet);
           if(!petsOnWaitingList.isEmpty()) {
               checkIn(petsOnWaitingList.poll());
           }
    }

    public  Queue<Pet> getPetsOnWaitingList() {
        return petsOnWaitingList;

    }
}