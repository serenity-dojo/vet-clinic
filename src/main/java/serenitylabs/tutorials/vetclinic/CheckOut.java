package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by Megha on 10-09-2016.
 */
public class CheckOut implements Performable{
    private final Pet pet;
    private final PetHotel hotel;

    @Step("{0} checksOut #pet from #hotel")
    @Override
    public <T extends Actor> void performAs(T t) {
        hotel.checkOut(pet);
    }

    public CheckOut(Pet pet, PetHotel hotel){
        this.pet = pet;
        this.hotel = hotel;
    }

    public static CheckOutBuilder aPet(Pet pet) {
        return new CheckOutBuilder(pet);
    }

    public static class CheckOutBuilder {
        private final Pet pet;
        public CheckOutBuilder(Pet pet){
            this.pet = pet;
        }

        public Performable from(PetHotel hotel) {
            return Instrumented.instanceOf(CheckOut.class).withProperties(pet, hotel);
        }
    }
}
