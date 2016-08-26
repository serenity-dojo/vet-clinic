package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.BookingResponse;
import serenitylabs.tutorials.vetclinic.model.Pet;

public interface AbilityToMakeBookings extends Ability {
    BookingResponse checkIn(Pet pet);
}
