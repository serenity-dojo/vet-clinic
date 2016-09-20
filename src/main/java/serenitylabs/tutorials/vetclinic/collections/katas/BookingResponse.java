package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * Created by kimahale on 9/20/2016.
 */
public class BookingResponse {

    private final boolean confirmedStatus;

    public BookingResponse(boolean confirmedStatus) {
        this.confirmedStatus = confirmedStatus;
    }

    public boolean isConfirmed() {
        return confirmedStatus;
    }

    public boolean isOnWaitingList() {
        return !confirmedStatus;
    }
}
