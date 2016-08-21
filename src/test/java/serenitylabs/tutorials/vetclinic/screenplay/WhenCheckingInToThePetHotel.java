package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.model.WaitingList;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel() {

        // GIVEN
        Actor petra = Actor.named("Petra the pet owner");

        GuestList guestList = new GuestList();
        WaitingList waitingList = new WaitingList();

        PetHotel petHotelCalifornia = new PetHotel(guestList, waitingList);

        // WHEN

        // THEN

       // assertThat(petHotelCalifornia.getPets(), hasItem(Pet.cat().named("Ginger")));


    }
}
