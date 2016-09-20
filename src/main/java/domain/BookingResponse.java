package domain;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pravyada on 9/20/2016.
 */
public abstract class BookingResponse implements BookingAcknowledgement  {

    private static  AtomicInteger ticketNumber = new AtomicInteger();
    private final Pet pet;
    private int ticketNum;


    public BookingResponse(Pet pet, int ticketNumber) {

        this.pet = pet;
        this.ticketNum = ticketNumber;
    }


    public static BookingResponse confirmedFor(Pet pet) {
        return new BookingConfirmation(pet, ticketNumber.incrementAndGet());
    }

    public static BookingResponse waitingListFor(Pet pet){
        return new PlacedOnWaitingList(pet, ticketNumber.incrementAndGet());
    }


    public int getTicketNum() {
        return ticketNum;
    }
    public Pet getPet() {
        return pet;
    }

}
