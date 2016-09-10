package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by siddharthk on 9/10/2016.
 */

@Subject("the pets in hotel")
public class TheRegisteredGuest implements Question<List<Pet>>{

    private static PetHotel petHotel;

    public TheRegisteredGuest(PetHotel petHotel) {

        this.petHotel = petHotel;
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        TheRegisteredGuest.petHotel = petHotel;
        return new TheRegisteredGuest(petHotel);
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
         return petHotel.getPets();
    }
}
