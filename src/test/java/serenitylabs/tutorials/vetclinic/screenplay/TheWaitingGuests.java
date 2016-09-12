package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.Collection;

/**
 * Created by sapurani on 9/12/2016.
 */
public class TheWaitingGuests implements Question<Collection<Pet>> {
    private final PetHotel petHotel;

    public TheWaitingGuests(PetHotel petHotel) {
        this.petHotel =  petHotel;
    }

    @Override
    public Collection<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }

    public static Question<Collection<Pet>> in(PetHotel petHotel) {
        return new TheWaitingGuests(petHotel);
    }
}
