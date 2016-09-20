package vetclinic.collections.katas;

import vetclinic.Pet;

/**
 * Created by sapurani on 9/20/2016.
 */
public class PlacedOnWaitingList extends BookingConfirmation {

    public PlacedOnWaitingList(int incrementAndget, Pet pet) {
        super(incrementAndget,pet);
    }
    @Override
    public boolean isConfirmed() {
        return false;
    }

    @Override
    public boolean isWaiting() {
        return true;
    }
}
