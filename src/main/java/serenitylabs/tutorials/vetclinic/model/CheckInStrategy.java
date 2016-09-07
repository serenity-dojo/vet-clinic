package serenitylabs.tutorials.vetclinic.model;

public interface CheckInStrategy {
    BookingResponse attemptToCheckIn(Pet pet);
}
