package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Task {

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Override
    @Step("{0} checks #pet into #petHotel")
    public <T extends Actor> void performAs(T t) {
        petHotel.checkIn(pet);
    }

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }

    public static class CheckInBuilder {

        private final Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public CheckIn into(PetHotel petHotel) {
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, petHotel);
        }

    }
}
