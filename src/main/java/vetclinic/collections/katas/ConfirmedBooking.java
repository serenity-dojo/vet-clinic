package vetclinic.collections.katas;

/**
 * Created by sapurani on 9/20/2016.
 */
public class ConfirmedBooking extends BookingConfirmation {
    @Override
    public boolean isConfirmed() {
        return true;
    }

    @Override
    public boolean isWaiting() {
        return false;
    }
}
