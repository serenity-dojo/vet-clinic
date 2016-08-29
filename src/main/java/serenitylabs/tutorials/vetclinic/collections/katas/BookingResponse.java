package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.concurrent.atomic.AtomicInteger;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.interfaces.BookingAcknowledgment;

public abstract class BookingResponse implements BookingAcknowledgment {

	private static AtomicInteger bookingNumberCounter = new AtomicInteger();
	private final int number;
	private final Pet pet;

	public BookingResponse(int number, Pet pet) {
		this.pet = pet;
		this.number = number;
	}

	public static BookingResponse confirmedFor(Pet pet) {
		return new BookingConfirmation(bookingNumberCounter.incrementAndGet(), pet);
	}

	public static BookingResponse waitingFor(Pet pet) {
		return new BookingConfirmation(bookingNumberCounter.incrementAndGet(), pet);
	}

	public Pet getPet() {
		return pet;
	}

	public int getNumber() {
		return number;
	}

}
