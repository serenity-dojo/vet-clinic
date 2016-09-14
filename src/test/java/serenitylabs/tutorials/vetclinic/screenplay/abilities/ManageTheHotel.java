package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by kimahale on 9/14/2016.
 */
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

    public List<Pet> getWaitingPets() {
        return petHotel.getWaitingList();
    }
}
