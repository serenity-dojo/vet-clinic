package serenitylabs.tutorials.vetclinic.collections.katas;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class BookingConfirmation extends BookingResponse{

	public BookingConfirmation(int number, PetEntity pet) {
		super(number, pet);
	}

	@Override
	public boolean isConfirmed() {
		return true;
	}

	@Override
	public boolean isOnWaitingList() {
		return false;
	}

}
