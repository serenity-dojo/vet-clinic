package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN

        petra.should(
                seeThat(TheRegisteredGuests.in(petHotel), hasItem(ginger)));
    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel hotel = PetHotel.called("Pet Hotel California");
        PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        // THEN
        petra.should(
                seeThat(TheRegisteredGuests.in(petHotel), not(hasItem(ginger))),
                seeThat(TheWaitingList.of(petHotel), hasItem(ginger))
                );

    }




}
