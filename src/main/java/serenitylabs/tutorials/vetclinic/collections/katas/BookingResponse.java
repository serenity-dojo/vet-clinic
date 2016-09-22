package serenitylabs.tutorials.vetclinic.collections.katas;


import serenitylabs.tutorials.vetclinic.Pet;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class BookingResponse {

    private static final int NO_BOOKING_DEFAULT_NUMBER = -1;
    private Pet pet;
    private static int bookingNumber;
    private boolean isConfirmed;
    private boolean onWaitingList;

    public BookingResponse(Pet pet, int bookingNumber, boolean isConfirmed, boolean onWaitingList) {
        this.pet = pet;
        this.bookingNumber = bookingNumber;
        this.isConfirmed = isConfirmed;
        this.onWaitingList = onWaitingList;
    }
    public static BookingResponse confirmFor(Pet pet) {
        return new BookingConfirmationResponse(pet,bookingNumber + 1);
    }

    public static BookingResponse onWaitingList(Pet pet) {
        return new WaitingListConfirmation(pet, NO_BOOKING_DEFAULT_NUMBER);
    }

    public Pet getPet() {
        return pet;
    }

    public static int getBookingNumber() {
        return bookingNumber;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public boolean onWaitingList() {
        return onWaitingList;
    }
}
