package domain;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * Created by pravyada on 9/20/2016.
 */
public class PetHotel  {
    public static final int MAX_SIZE = 20;
    private  Collection<Pet> petList = new TreeSet<>(comparing(Pet::getName));
    private static Queue<Pet> petsInWaitingList = new LinkedList<>();

private static final Map<HotelAvailability,CheckInStrategy> CHECK_IN_STRATEGY  = new HashMap<HotelAvailability,CheckInStrategy>();
     {
         CHECK_IN_STRATEGY .put(HotelAvailability.Available,new ConfirmBookingStrategy(petList));
         CHECK_IN_STRATEGY .put(HotelAvailability.Full,new WaitingListStrategy(petsInWaitingList));
    }

    public List<Pet> getPets(){
        return  new ArrayList<>(petList);
    }

    public BookingResponse checkIn(Pet pet) {
        CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY .get(checkInStrategy());
        return  checkInStrategy.doCheckIn(pet);
    }

    private HotelAvailability checkInStrategy() {
        return petList.size()<MAX_SIZE ? HotelAvailability.Available : HotelAvailability.Full;
    }

    public void checkOut(Pet pet){
        petList.remove(pet);
        if(!petsInWaitingList.isEmpty())
            checkIn(petsInWaitingList.poll());
    }


    public HotelAvailability getAvailablility() {
         return petList.size()<MAX_SIZE ? HotelAvailability.Available : HotelAvailability.Full;
    }
}
