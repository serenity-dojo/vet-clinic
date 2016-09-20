package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

/**
 * Created by kimahale on 9/20/2016.
 */
public class PetHotel {

    private Collection<Pet> pets= new TreeSet<>(Comparator.comparing(Pet::getName));
    public static int DEFAULT_MAXIMUM_CAPACITY = 20;
    private Queue<Pet> waitingList = new LinkedList<>();

    public List<Pet> getPets() {
        return new ArrayList(pets);
    }

    public BookingResponse checkIn(Pet pet) {
        boolean confirmStatus= false;
        if (pets.size() <DEFAULT_MAXIMUM_CAPACITY) {
            pets.add(pet);
            confirmStatus=true;
        }
        else
            waitingList.add(pet);
        return new BookingResponse(confirmStatus);
    }

    public List<Pet> getWaitingList() {
        return new ArrayList<>(waitingList);
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);
        if (!waitingList.isEmpty()) {
            checkIn(waitingList.poll());
        }
    }
}
