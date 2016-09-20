package serenitylabs.tutorials.vetclinic.collections.katas;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.questions.TheRegisteredGuest;
import serenitylabs.tutorials.vetclinic.collections.katas.questions.TheBookingStatus;
import serenitylabs.tutorials.vetclinic.collections.katas.questions.TheWaitingGuest;
import serenitylabs.tutorials.vetclinic.collections.katas.questions.TheWaitingStatus;
import serenitylabs.tutorials.vetclinic.collections.katas.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.collections.katas.tasks.CheckOut;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;


@RunWith(SerenityRunner.class)
public class WhenBookingPetsIntoAPetHotel {

    Actor vikrant, john;
    PetHotel petHotel;

    @Before
    public void setUp() {
        petHotel = new PetHotel();
        vikrant = Actor.named("Vikrant Dheer");
        john = Actor.named("John Smart");
    }

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), hasSize(0)));
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), hasItem(tommy)));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");
        Pet goldy = Pet.fish().named("Goldy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel), CheckIn.aPet(goldy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), hasItems(goldy, tommy)));
    }

    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {
        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");
        Pet goldy = Pet.fish().named("Goldy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel),
                CheckIn.aPet(goldy).in(petHotel),
                CheckIn.aPet(tommy).in(petHotel)); //again checkin tommy

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), containsInAnyOrder(goldy, tommy)));
    }

    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        //GIVEN
        Pet zira = Pet.dog().named("Zira the Dog");
        Pet goldy = Pet.fish().named("Goldy the Fish");
        Pet anabelle = Pet.cat().named("Anabelle the Cat");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(zira).in(petHotel),
                CheckIn.aPet(anabelle).in(petHotel),
                CheckIn.aPet(goldy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), contains(anabelle, goldy, zira)));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(20).checkedIn();  //adding random 20 pets as of now
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), not(hasItem(tommy))));
    }

    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(20).checkedIn();  //adding random 20 pets as of now
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheWaitingGuest.isOnWaitingListIn(petHotel), hasItem(tommy)));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(19).checkedIn();  //adding random 20 pets as of now
        Pet tommy = Pet.dog().named("Tommy");
        Pet goldy = Pet.fish().named("Goldy the Fish");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel)); //VIKRANT trying to checkin

        when(john).attemptsTo(CheckIn.aPet(goldy).in(petHotel)); //JOHN trying to checkin

        when(vikrant).attemptsTo(CheckOut.aPet(tommy).in(petHotel)); //VIKRANT trying to checkout

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), hasItem(goldy)));
    }


    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(19).checkedIn();  //adding random 20 pets as of now
        Pet tommy = Pet.dog().named("Tommy");
        Pet goldy = Pet.fish().named("Goldy the Fish");
        Pet anabelle = Pet.cat().named("Anabelle the Cat");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel)); //VIKRANT trying to checkin

        when(john).attemptsTo(CheckIn.aPet(goldy).in(petHotel)); //JOHN trying to checkin

        when(vikrant).attemptsTo(CheckIn.aPet(anabelle).in(petHotel)); //VIKRANT trying to checkin

        when(vikrant).attemptsTo(CheckOut.aPet(tommy).in(petHotel)); //VIKRANT trying to checkout

        //THEN
        then(vikrant).should(seeThat(TheRegisteredGuest.registeredIn(petHotel), hasItem(goldy)),
                seeThat(TheWaitingGuest.isOnWaitingListIn(petHotel), hasItem(anabelle)));
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        //GIVEN
        Pet tommy = Pet.dog().named("Tommy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheBookingStatus.of(tommy).isConfirmed(), is(true)));
    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {
        //GIVEN
        PetHotel petHotel = APetHotel.with(19).checkedIn();
        Pet tommy = Pet.dog().named("Tommy");
        Pet goldy = Pet.fish().named("Goldy");

        //WHEN
        when(vikrant).attemptsTo(CheckIn.aPet(tommy).in(petHotel), CheckIn.aPet(goldy).in(petHotel));

        //THEN
        then(vikrant).should(seeThat(TheWaitingStatus.of(goldy).isConfirmed(), is(false)));
    }
}
