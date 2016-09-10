package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by siddharthk on 9/9/2016.
 */
@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    Actor petra;
    Pet fido;
    PetHotel westin;

    @Before
    public void setUp() throws Exception {
        petra = Actor.named("Petra the pet owner");
        fido = Pet.cat().named("Fido");
        westin = PetHotel.called("Westin the hotel");
    }

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() throws Exception {

        //WHEN
        petra.attemptsTo(CheckIn.aPet(fido).into(westin));

        //THEN
        assertThat(westin.getPets(),hasItems(fido));

    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel() throws Exception {

        //GIVEN
        petra.wasAbleTo(CheckIn.aPet(fido).into(westin));

        //WHEN
        petra.attemptsTo(CheckOut.aPet(fido).from(westin));

        //THEN
        assertThat(westin.getPets(),not(hasItems(fido)));

    }
}
