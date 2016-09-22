package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class WaitingListConfirmation extends BookingResponse {

    public WaitingListConfirmation(Pet pet, int bookingDefaultNumber) {
        super(pet, bookingDefaultNumber, false, true);
    }
}
