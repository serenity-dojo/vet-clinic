package serenitylabs.tutorials.vetclinic.collections.katas.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetHotel;

/**
 * Created by vdheer on 9/20/2016.
 */
public class CheckOut implements Performable {
    private final Pet pet;
    private final PetHotel petHotel;

    public CheckOut(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checks-in #pet into #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        petHotel.checkOut(pet);
    }

    public static CheckOutBuilder aPet(Pet pet) {
        return new CheckOutBuilder(pet);
    }

    public static class CheckOutBuilder {
        private Object pet;

        public CheckOutBuilder(Object pet) {
            this.pet = pet;
        }

        public Performable in(PetHotel petHotel) {
            return Instrumented.instanceOf(CheckOut.class).withProperties(pet, petHotel);
        }
    }
}
