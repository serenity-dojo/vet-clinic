package vetclinic.collections.katas;

import vetclinic.Pet;

/**
 * Created by sapurani on 9/20/2016.
 */
public class ConfirmedBooking extends BookingConfirmation {
    public ConfirmedBooking(int incrementAndget, Pet pet) {
        super(incrementAndget,pet);
    }

    @Override
    public boolean isConfirmed() {
        return true;
    }

    @Override
    public boolean isWaiting() {
        return false;
    }
}
