package domain;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by pravyada on 9/20/2016.
 */
public interface CheckInStrategy  {
    public BookingResponse doCheckIn(Pet pet);
}
