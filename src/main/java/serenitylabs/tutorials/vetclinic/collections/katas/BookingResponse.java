package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sapurani on 8/30/2016.
 */
public abstract class BookingResponse implements BookingAcknowledgement {
    private static AtomicInteger bookingNumberCounter = new AtomicInteger();
    private final int number;
    private final Pet pet;

    public BookingResponse(int number, Pet pet) {
        this.number = number;
        this.pet = pet;
    }

    public static BookingResponse confirmedFor(Pet pet) {
        return new BookingConfirmation(bookingNumberCounter.incrementAndGet(), pet);
    }

    public static BookingResponse waitingListFor(Pet pet) {
        return new PlacedOnWaitingList(bookingNumberCounter.incrementAndGet(), pet);
    }

    public Pet getPet() {
        return pet;
    }

}
