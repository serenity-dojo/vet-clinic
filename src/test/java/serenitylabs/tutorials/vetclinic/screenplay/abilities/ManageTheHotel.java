package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class ManageTheHotel implements Ability {

    private final PetHotel petHotel;

    public ManageTheHotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public void bookPet(Pet pet) {
        this.petHotel.checkIn(pet);
    }
}
