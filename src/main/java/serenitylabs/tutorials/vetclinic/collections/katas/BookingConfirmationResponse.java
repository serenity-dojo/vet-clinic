package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class BookingConfirmationResponse extends BookingResponse {

    public BookingConfirmationResponse(Pet pet, int bookingNumber) {
        super(pet, bookingNumber , true, false);
    }
}
