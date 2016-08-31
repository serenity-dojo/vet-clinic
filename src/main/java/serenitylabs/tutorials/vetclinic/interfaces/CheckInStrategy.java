package serenitylabs.tutorials.vetclinic.interfaces;

import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.BookingResponse;
import serenitylabs.tutorials.vetclinic.Pet;


public interface CheckInStrategy {

    BookingResponse attemptToCheckIn(Pet pet);
}
