package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by sapurani on 9/9/2016.
 */
public class Checkout implements Performable{
    private final Pet pet;
    private final PetHotel petHotel;

    public Checkout(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        petHotel.checkOut(pet);
    }

    public static CheckoutBuilder apet(Pet ginger) {
        return new CheckoutBuilder(ginger);
    }

    public static class CheckoutBuilder {
        private final Pet pet;

        public CheckoutBuilder(Pet pet) {
            this.pet=pet;
        }

        public Performable from(PetHotel petHotel) {
            return Instrumented.instanceOf(Checkout.class).withProperties(pet, petHotel);
        }
    }
}
