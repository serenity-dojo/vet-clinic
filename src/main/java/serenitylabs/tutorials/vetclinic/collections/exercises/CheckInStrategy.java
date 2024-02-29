package serenitylabs.tutorials.vetclinic.collections.exercises;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public interface CheckInStrategy {
	
	 BookingResponse attemptToCheckIn(PetEntity pet);

}