package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * Created by vdheer on 9/20/2016.
 */
public class PetHotel {
    private final Collection<Pet> registeredPets = new TreeSet<>(comparing(Pet::getName));
    private final Queue<Pet> waitingListOfPets = new LinkedList<>();
    private static final int DEFAULT_MAXIMUM_CAPACITY = 20;

    private static String hotelName;

    public List<Pet> getRegisteredPets() {
        return new ArrayList<>(registeredPets);
    }

    public BookingResponse checkIn(Pet pet) {
        return (registeredPets.size() < DEFAULT_MAXIMUM_CAPACITY)
                ? new BookingResponse(registeredPets.add(pet))
                : new BookingResponse(waitingListOfPets.add(pet));
    }

    public List<Pet> getWaitingList() {
        return new ArrayList<>(waitingListOfPets);
    }

    public void checkOut(Pet pet) {
        if (!waitingListOfPets.isEmpty()) {
            registeredPets.remove(pet);
            checkIn(waitingListOfPets.poll());
        }
    }
}
