package serenitylabs.tutorials.vetclinic.collections.katas.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetHotel;

import java.util.List;

/**
 * Created by vdheer on 9/20/2016.
 */
public class ManageThehotel implements Ability {
    private PetHotel petHotel;

    public ManageThehotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

//    public void checkIn(Pet pet) {
//        petHotel.checkIn(pet);
//    }

    public List<Pet> getRegisteredPets() {
        return petHotel.getRegisteredPets();
    }

    public List<Pet> getPetsOnWaitingList() {
        return petHotel.getWaitingList();
    }
}
