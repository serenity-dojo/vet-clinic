package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * Created by vdheer on 9/20/2016.
 */
public class BookingResponse {
    private boolean petsAdded;

    public BookingResponse(boolean petsAdded) {
        this.petsAdded = petsAdded;
    }

    public BookingResponse() {

    }

    public boolean isConfirmed() {
        return petsAdded;
    }

    public boolean isOnWaitingList() {
        return !petsAdded;
    }


}
