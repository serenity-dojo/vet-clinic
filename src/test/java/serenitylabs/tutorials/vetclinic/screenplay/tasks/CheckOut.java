package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by siddharthk on 9/10/2016.
 */
public class CheckOut implements Performable{
    private final Pet pet;
    private final PetHotel petHotel;

    public CheckOut(Pet pet, PetHotel petHotel) {

        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checksout #pet from #petHotel")
    @Override
    public <T extends Actor> void performAs(T t) {
             petHotel.checkOut(pet);
    }

    public static CheckOutBuilder aPet(Pet fido) {
    return new CheckOutBuilder(fido);
    }

    public static class CheckOutBuilder {
        private Pet pet;

        public CheckOutBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable from(PetHotel petHotel) {
            return Instrumented.instanceOf(CheckOut.class).withProperties(pet,petHotel);
        }
    }
}
