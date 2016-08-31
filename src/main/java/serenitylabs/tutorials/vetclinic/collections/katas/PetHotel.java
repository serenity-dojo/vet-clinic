package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;


/**
 * Created by aatchoud on 8/29/2016.
 */
public class PetHotel {

    public static final int MAXIMUM_PETS = 20;
    private Collection<Pet> pets = new TreeSet<>(Comparator.comparing(Pet::getName));
    private final Queue<Pet> waitingList = new LinkedList<>();

    public Collection<Pet> getWaitingList() {
        return waitingList;
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);

        if(!waitingList.isEmpty())
        checkIn(waitingList.poll());

    }


    private enum HotelAvailability{Available,Full}

    private HotelAvailability currentAvailability(){
        return (pets.size() >= MAXIMUM_PETS) ? HotelAvailability.Full : HotelAvailability.Available;
    }

    private static final Map<HotelAvailability,CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();
    {
        CHECK_IN_STRATEGY.put(HotelAvailability.Available,new ConfirmBookingStrategy(pets));
        CHECK_IN_STRATEGY.put(HotelAvailability.Full,new WaitingListStrategy(waitingList));
    }



    public List<Pet> getPets(){
        return new ArrayList<>(pets);
    }

    public BookingResponse checkIn(Pet pet){
        CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(currentAvailability());
        return checkInStrategy.attemptTocheckIn(pet);
    }


}
