package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sapurani on 9/8/2016.
 */
@RunWith(SerenityRunner.class)
public class WhenCheckingIntoThePetHotel {
    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {
        //GIVEN
        Actor petra = Actor.named("Petra");
        Pet ginger = Pet.cat().named("ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel Pune");

        //WHEN
        petra.attemptsTo(CheckIn.apet(ginger).into(petHotel));

        // THEN
        assertThat(petHotel.getPets(), hasItem(ginger));

    }

    @Test
    public void petra_checks_out_her_pet_cat_from_the_hotel() {
        //GIVEN
        Actor petra = Actor.named("Petra");
        Pet ginger = Pet.cat().named("ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel Pune");

        //WHEN
        petra.attemptsTo(CheckIn.apet(ginger).into(petHotel));
        //AND
        petra.attemptsTo(Checkout.apet(ginger).from(petHotel));

        // THEN

        assertThat(petHotel.getPets(), not(hasItem(ginger)));

    }
}