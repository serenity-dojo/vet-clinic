package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.concurrent.atomic.AtomicInteger;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public abstract class BookingResponse implements BookingAcknowledgement {
	
	private static AtomicInteger bookingNumberCounter = new AtomicInteger();
    private final int number;
    private final PetEntity pet;
    
	public BookingResponse(int number, PetEntity pet) {
		this.number = number;
		this.pet = pet;
	}

	public static BookingResponse confirmedFor(PetEntity pet) {
        return new BookingConfirmation(bookingNumberCounter.incrementAndGet(), pet);
    }

    public static BookingResponse waitingListFor(PetEntity pet) {
        return new PlacedOnWaitingList(bookingNumberCounter.incrementAndGet(), pet);
    }
    
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the pet
	 */
	public PetEntity getPet() {
		return pet;
	}
	   
}