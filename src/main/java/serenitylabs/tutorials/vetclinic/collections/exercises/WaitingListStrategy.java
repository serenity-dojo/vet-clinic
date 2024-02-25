package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.Collection;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class WaitingListStrategy implements CheckInStrategy {

	private final Collection<PetEntity> relevantPets;

	public WaitingListStrategy(Collection<PetEntity> relevantPets) {
		this.relevantPets = relevantPets;
	}

	@Override
	public BookingResponse attemptToCheckIn(PetEntity pet) {
		relevantPets.add(pet);
        return BookingResponse.waitingListFor(pet);
	}
	
}
