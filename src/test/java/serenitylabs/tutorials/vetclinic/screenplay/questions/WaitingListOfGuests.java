package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by kimahale on 9/12/2016.
 */
public class WaitingListOfGuests implements Question<List<Pet>>{
    private final PetHotel petHotel;

    public WaitingListOfGuests(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public static Question<List<Pet>> of(PetHotel petHotel) {
        return new WaitingListOfGuests(petHotel);
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }
}
