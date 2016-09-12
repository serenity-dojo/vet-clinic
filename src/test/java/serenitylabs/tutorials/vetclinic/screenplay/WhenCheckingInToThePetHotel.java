package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


/**
 * Created by kimahale on 9/12/2016.
 */
@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() throws Exception {

        // GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN
        assertThat(petHotel.getPets(), hasItem(ginger));
    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel() throws Exception {
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        assertThat(petHotel.getPets(), not(hasItem(ginger)));



    }
}
