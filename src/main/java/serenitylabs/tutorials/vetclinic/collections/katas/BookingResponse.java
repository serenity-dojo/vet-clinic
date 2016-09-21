package serenitylabs.tutorials.vetclinic.collections.katas;

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
