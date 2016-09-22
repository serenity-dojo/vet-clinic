package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by siddharthk on 9/22/2016.
 */
public interface CheckInStrategy {
     BookingResponse checkIn(Pet fido);
}
