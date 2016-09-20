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
@Subject("the Waiting Pets in the hotel")
public class TheWaitingGuest implements Question<List<Pet>> {
    private PetHotel petHotel;

    public TheWaitingGuest(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }

    public static Question<List<Pet>> isOnWaitingListIn(PetHotel petHotel) {
        return new TheWaitingGuest(petHotel);
    }
}
