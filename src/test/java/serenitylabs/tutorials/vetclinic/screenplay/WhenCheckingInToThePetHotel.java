package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.model.WaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuestsOnTheWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.APetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {


    PetHotel petHotel;
    @Before
    public void estabilishHotel() {

        GuestList guestList = new GuestList();
        WaitingList waitingList = new WaitingList();
        petHotel = new PetHotel("Pet Hotel California", guestList, waitingList);
    }


    @Test
    public void petra_checks_her_cat_in_when_the_hotel_is_full() {
        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        // THEN
        petra.should(
                seeThat(TheRegisteredGuests.in(petHotel), not(hasItem(ginger))),
                seeThat(TheGuestsOnTheWaitingList.forHotel(petHotel), hasItem(ginger))
        );

    }
}
