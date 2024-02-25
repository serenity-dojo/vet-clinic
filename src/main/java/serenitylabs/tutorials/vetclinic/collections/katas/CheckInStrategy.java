package serenitylabs.tutorials.vetclinic.collections.katas;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public interface CheckInStrategy {
	
	 BookingResponse attemptToCheckIn(PetEntity pet);

}