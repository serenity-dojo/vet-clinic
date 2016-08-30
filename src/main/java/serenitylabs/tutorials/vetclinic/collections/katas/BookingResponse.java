package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * Created by sapurani on 8/30/2016.
 */
public class BookingResponse {
    private final boolean booked;

    public BookingResponse(boolean bookingResponse) {
        this.booked = bookingResponse;
    }

    public boolean isConfirmed() {
        return booked;
    }
}
