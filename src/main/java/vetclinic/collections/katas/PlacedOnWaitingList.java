package vetclinic.collections.katas;

/**
 * Created by sapurani on 9/20/2016.
 */
public class PlacedOnWaitingList extends BookingConfirmation {


    @Override
    public boolean isConfirmed() {
        return false;
    }

    @Override
    public boolean isWaiting() {
        return true;
    }
}
