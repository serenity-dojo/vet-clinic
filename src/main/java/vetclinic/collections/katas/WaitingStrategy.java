package vetclinic.collections.katas;

import vetclinic.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sapurani on 9/20/2016.
 */
public class WaitingStrategy implements BookingStratgey {
    private Queue<Pet> pets = new LinkedList<>();

    public WaitingStrategy(Queue<Pet> waitingPets) {
        this.pets=waitingPets;
    }

    @Override
    public BookingConfirmation checkIn(Pet pet) {
        pets.add(pet);
        return PlacedOnWaitingList.waitingFor(pet);
    }
}
