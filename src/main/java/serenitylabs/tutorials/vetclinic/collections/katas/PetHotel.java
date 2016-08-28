package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static java.util.Comparator.comparing;

public class PetHotel {

    public static final int MAXIMUM_PETS = 20;

    private Collection<Pet> pets = new TreeSet<>(comparing(Pet::getName));
    private Queue<Pet> waitingList = new LinkedList<>();

    public List<Pet> getPets() {
        return new ArrayList<>(pets);
    }

    public void feedTheGuests() {
        for (Pet pet : getPets()) {
            if (pet.getBreed() == Breed.Cat) {
                pet.feed(10 * pet.getWeightInKilos(), PetFood.KittyKat);
            } else if (pet.getBreed() == Breed.Dog) {
                pet.feed(20 * pet.getWeightInKilos(), PetFood.FidosFood);
            }
        }
    }

    private enum HotelAvailability {Available, Full}

    private static final Map<HotelAvailability, CheckInStrategy> CHECK_IN_STRATEGY = new HashMap<>();

    {
        CHECK_IN_STRATEGY.put(HotelAvailability.Available, new ConfirmBookingStrategy(pets));
        CHECK_IN_STRATEGY.put(HotelAvailability.Full, new WaitingListStrategy(waitingList));
    }

    private HotelAvailability currentAvailability() {
        return (pets.size() >= MAXIMUM_PETS) ? HotelAvailability.Full : HotelAvailability.Available;
    }

    public BookingResponse checkIn(Pet pet) {
        CheckInStrategy checkInStrategy = CHECK_IN_STRATEGY.get(currentAvailability());
        return checkInStrategy.attemptToCheckIn(pet);
    }

    public Collection<Pet> getWaitingList() {
        return new ArrayList<>(waitingList);
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);

        if (!waitingList.isEmpty()) {
            checkIn(waitingList.poll());
        }
    }
}
