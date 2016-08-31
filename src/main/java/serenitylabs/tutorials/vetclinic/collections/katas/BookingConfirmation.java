package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by aatchoud on 8/29/2016.
 */
public class BookingConfirmation extends BookingResponse {

    public BookingConfirmation(int number,Pet pet){
        super(number,pet);
    }

    @Override
    public boolean isConfirmed() {
        return true;
    }

    @Override
    public boolean isOnWaitingList() {
        return false;
    }
}
