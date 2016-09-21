package domain;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pravyada on 9/20/2016.
 */
public class BookingConfirmation extends BookingResponse
{

    public BookingConfirmation(Pet pet, int ticketNumber) {
        super(pet,ticketNumber);
    }


    @Override
    public boolean isConfirmed() {
        return true;
    }

    @Override
    public boolean isOnWaiting() {
        return false;
    }
}
