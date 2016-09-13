package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

public interface CheckInStrategy {
    BookingResponse attemptToCheckIn(Pet pet);
}
