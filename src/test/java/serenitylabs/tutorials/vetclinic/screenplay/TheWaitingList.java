package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by siddharthk on 9/10/2016.
 */

public class TheWaitingList implements Question<List<Pet>>{

    private PetHotel petHotel;

    public TheWaitingList(PetHotel petHotel) {

        this.petHotel = petHotel;
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheWaitingList(petHotel);
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }
}
