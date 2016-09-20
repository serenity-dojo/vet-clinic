package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * Created by pawpawar on 9/20/2016.
 */
public class BookingResponse {
    private final boolean isBooked;

    public BookingResponse(boolean isBooked) {
        this.isBooked = isBooked;
    }


    public boolean isConfirmed() {
        return isBooked;
    }

    public boolean isOnWaitingList() {
        return !isBooked;
    }
}
