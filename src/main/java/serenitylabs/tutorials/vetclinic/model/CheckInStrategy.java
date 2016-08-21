package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Pet;

public interface CheckInStrategy {
    BookingResponse attemptToCheckIn(Pet pet);
}
