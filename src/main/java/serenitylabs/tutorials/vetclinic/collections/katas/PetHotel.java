package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.*;

/**
 * Created by pawpawar on 9/20/2016.
 */
public class PetHotel {
    private Collection<Pet> pets = new TreeSet<>(Comparator.comparing(Pet::getName));

    public static int DEFAULT_MAX_CAPACITY = 30;
    private final String name;
    private final int maxCapacity;

    private Queue<Pet> waitingList = new LinkedList<>();

    public Collection<Pet> getPets() {
        return pets;
    }
    public PetHotel(String name, int maximumCapacity) {

        this.maxCapacity= maximumCapacity;
        this.name = name;
    }

    public static PetHotel named(String newPetName) {

        return new PetHotel(newPetName, DEFAULT_MAX_CAPACITY);
    }

    public BookingResponse checkIn(Pet unknownPet) {
        boolean allPetsWereAdded = false;

        if (pets.size() < DEFAULT_MAX_CAPACITY) {
            allPetsWereAdded = pets.add(unknownPet);

        } else {
            waitingList.add(unknownPet);
        }
        return new BookingResponse(allPetsWereAdded);
    }

    public Collection<Pet> getWaitingList() {

        return new ArrayList<>(waitingList);
    }

    public void checkOut(Pet unknownPet) {

        pets.remove(unknownPet);
        if (!waitingList.isEmpty()) {

            checkIn(waitingList.poll());
        }
    }
}
