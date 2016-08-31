package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by aatchoud on 8/29/2016.
 */
public interface CheckInStrategy {
    BookingResponse attemptTocheckIn(Pet pet);
}
