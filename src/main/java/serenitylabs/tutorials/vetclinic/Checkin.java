package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by Megha on 10-09-2016.
 */
public class Checkin implements Performable{


    private final Pet pet;
    private final PetHotel hotel;

    public Checkin(Pet pet, PetHotel hotel) {
        this.pet = pet;
        this.hotel = hotel;
    }
    @Step("{0} checks #pet into #hotel")
    @Override
    public <T extends Actor> void performAs(T t) {
            hotel.checkIn(pet);
    }


    public static CheckinBuilder aPet(Pet pet) {
        return new CheckinBuilder(pet);
    }

    public static class CheckinBuilder {
        private final Pet pet;

        public CheckinBuilder(Pet pet ){
            this.pet = pet;
        }

        public Performable into(PetHotel hotel) {
            return Instrumented.instanceOf(Checkin.class).withProperties(pet, hotel);
        }
    }
}
