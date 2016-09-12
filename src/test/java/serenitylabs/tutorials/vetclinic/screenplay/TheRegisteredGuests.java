package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by sapurani on 9/12/2016.
 */
public class TheRegisteredGuests implements Question<List<Pet>>{
    private final PetHotel petHotel;

    public TheRegisteredGuests(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheRegisteredGuests(petHotel);
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getPets();
    }
}
