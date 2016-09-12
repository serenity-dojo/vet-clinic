package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by kimahale on 9/12/2016.
 */
@Subject("the pets in the hotel")
public class TheRegisteredGuest implements Question<List<Pet>> {
    private final PetHotel petHotel;

    public TheRegisteredGuest(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getPets();
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheRegisteredGuest(petHotel);
    }
}
