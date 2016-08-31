package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

public class ManageTheHotel implements Ability {
    private final PetHotel petHotel;

    public ManageTheHotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public void checkInPet(Pet pet) {
        petHotel.checkIn(pet);
    }

    public List<Pet> getRegisteredPets() {
        return petHotel.getPets();
    }

    public List<Pet> getWaitingList() {
        return petHotel.getWaitingList();
    }
}
