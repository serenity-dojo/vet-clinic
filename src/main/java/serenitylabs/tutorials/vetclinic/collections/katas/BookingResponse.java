package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by aatchoud on 8/29/2016.
 */
public abstract class BookingResponse implements BookingAcknowledgement {
    private static AtomicInteger bookingNumberCounter = new AtomicInteger();

    private final int number;
    private final Pet pet;

    protected BookingResponse(int number, Pet pet) {
        this.number = number;
        this.pet = pet;
    }


    public int getNumber() {
        return number;
    }

    public Pet getPet() {
        return pet;
    }

    public static BookingResponse confirrmedFor(Pet pet) {
        return new BookingConfirmation(bookingNumberCounter.incrementAndGet(),pet);
    }

    public static BookingResponse waitingListFor(Pet pet) {
        return new PlacedOnWaitingList(bookingNumberCounter.incrementAndGet(), pet);
    }
}
