package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by Megha on 11-09-2016.
 */

@Subject("the pet in the hotel")
public class TheWaitingList implements Question<List<Pet>> {

    private PetHotel petHotel;

    public TheWaitingList(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }

    public static Question<List<Pet>> of(PetHotel petHotel) {
        return new TheWaitingList(petHotel);
    }
}
