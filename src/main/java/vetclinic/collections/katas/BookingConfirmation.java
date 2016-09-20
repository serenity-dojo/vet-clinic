package vetclinic.collections.katas;

import vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sapurani on 9/20/2016.
 */
public abstract  class BookingConfirmation implements  BookingResponse{
    private static AtomicInteger bookingNumberCounter = new AtomicInteger();
    private final int number;
    private final Pet pet;

    public BookingConfirmation (int number, Pet pet) {
        this.number = number;
        this.pet = pet;
    }

    public static BookingConfirmation confirmedFor(Pet pet) {
        return new ConfirmedBooking(bookingNumberCounter.get(),pet);
    }

    public static BookingConfirmation waitingFor(Pet pet) {
        return new PlacedOnWaitingList(bookingNumberCounter.get(),pet);
    }

    public Pet getPet() {
        return pet;
    }


}
