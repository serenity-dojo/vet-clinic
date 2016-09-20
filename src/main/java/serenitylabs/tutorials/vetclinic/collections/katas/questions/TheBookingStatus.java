package serenitylabs.tutorials.vetclinic.collections.katas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.BookingResponse;

/**
 * Created by vdheer on 9/20/2016.
 */
public class TheBookingStatus implements Question<Boolean> {

    private BookingResponse bookingResponse = new BookingResponse(true);

    private Pet pet;

    public TheBookingStatus(Pet pet) {
        this.pet = pet;
    }

    public static TheStatusBuilder of(Pet pet) {
        return new TheStatusBuilder(pet);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return bookingResponse.isConfirmed();
    }

    public static class TheStatusBuilder {
        private Pet pet;

        public TheStatusBuilder(Pet pet) {
            this.pet = pet;
        }

        public Question<Boolean> isConfirmed() {
            return new TheBookingStatus(pet);
        }
    }
}
