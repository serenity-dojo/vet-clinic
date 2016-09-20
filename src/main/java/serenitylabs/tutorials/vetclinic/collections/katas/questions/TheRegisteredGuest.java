package serenitylabs.tutorials.vetclinic.collections.katas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetHotel;

import java.util.List;

/**
 * Created by vdheer on 9/20/2016.
 */
@Subject("the Pets in the hotel")
public class TheRegisteredGuest implements Question<List<Pet>> {
    private PetHotel petHotel;

    public TheRegisteredGuest(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getRegisteredPets();
    }

    public static Question<List<Pet>> registeredIn(PetHotel petHotel) {
        return new TheRegisteredGuest(petHotel);
    }
}
