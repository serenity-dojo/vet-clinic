package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by Home on 9/21/2016.
 */
public class BookingResponse {
    private Pet pet;
    private int bookingNumber;

    public BookingResponse(Pet pet, int bookingNumber){
        this.pet = pet;
        this.bookingNumber = bookingNumber;
    }

    public boolean isConfirmed() {
        return true;
    }

    public Pet getName() {
        return pet;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    }
