package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.Collection;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class ConfirmBookingStrategy implements CheckInStrategy {

	private final Collection<PetEntity> pets;

	public ConfirmBookingStrategy(Collection<PetEntity> pets) {
		this.pets = pets;
	}

	@Override
	public BookingResponse attemptToCheckIn(PetEntity pet) {
		 pets.add(pet);
	     return BookingResponse.confirmedFor(pet);
	}
	
}