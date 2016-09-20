package serenitylabs.tutorials.vetclinic.collections.katas.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.jruby.ir.instructions.Instr;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.BookingResponse;
import serenitylabs.tutorials.vetclinic.collections.katas.PetHotel;

/**
 * Created by vdheer on 9/20/2016.
 */
public class CheckIn implements Performable {
    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Step("{0} checks-in #pet into #petHotel")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingResponse bookingResponse = petHotel.checkIn(pet);
    }

    public static CheckInBuilder aPet(Pet pet) {
        return new CheckInBuilder(pet);
    }

    public static class CheckInBuilder {
        private Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable in(PetHotel petHotel) {
            //return new CheckIn(pet, petHotel);
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, petHotel);
        }
    }
}
