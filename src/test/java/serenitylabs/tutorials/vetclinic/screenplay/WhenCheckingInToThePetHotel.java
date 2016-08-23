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
import serenitylabs.tutorials.vetclinic.screenplay.abilities.Manage;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuests;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuestsOnTheWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.APetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.FillTheHotel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {


    PetHotel petHotel;
    Actor harry;

    Actor petra;
    Pet ginger;

    @Before
    public void estabilishHotel() {

        GuestList guestList = new GuestList();
        WaitingList waitingList = new WaitingList();
        petHotel = new PetHotel("Pet Hotel California", guestList, waitingList);

        harry = Actor.named("Harry the hotel manager")
                .can(Manage.the(guestList))
                .can(Manage.the(waitingList))
                .can(Manage.the(petHotel));

        petra = Actor.named("Petra the pet owner");
        ginger = Pet.cat().named("Ginger");
    }

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {


        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN
        harry.should(seeThat(TheGuests.registerdInTheHotel(), hasItem(ginger)));
    }

    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full() {

        // GIVEN
        harry.wasAbleTo(
                FillTheHotel.with(20).pets()
        );

        // WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        // THEN
        harry.should(seeThat(TheGuests.onTheWaitingList(), hasItem(ginger)),
                     seeThat(TheGuests.registerdInTheHotel(), not(hasItem(ginger))));
    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel() {

        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Pet Hotel California");

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        // THEN
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), not(hasItem(ginger))));

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
                seeThat(TheGuestsOnTheWaitingList.forHotel(petHotel), hasItem(ginger)));

    }

}
