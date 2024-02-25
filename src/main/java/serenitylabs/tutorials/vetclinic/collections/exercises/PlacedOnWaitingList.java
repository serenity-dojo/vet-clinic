package serenitylabs.tutorials.vetclinic.collections.exercises;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;

public class PlacedOnWaitingList extends BookingResponse {

	public PlacedOnWaitingList(int number, PetEntity pet) {
		super(number, pet);
	}

	@Override
	public boolean isConfirmed() {
		return false;
	}

	@Override
	public boolean isOnWaitingList() {
		return true;
	}

}