package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by sapurani on 9/9/2016.
 */
public class CheckIn implements Performable{

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotels) {
        
        this.pet = pet;
        this.petHotel = petHotels;
    }


    @Step("{0} checks #pet into #petHotel")
    @Override
    public <T extends Actor> void performAs(T t) {
        petHotel.checkIn(pet);
    }

    public static  CheckInBuilder apet(Pet pet){
        return  new CheckInBuilder(pet);
    }
    public static class CheckInBuilder {
        private final Pet pet;

        public CheckInBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            return Instrumented.instanceOf(CheckIn.class).withProperties(pet, petHotel);
        }
    }
}
