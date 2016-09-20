package serenitylabs.tutorials.vetclinic.collections.katas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.BookingResponse;

/**
 * Created by vdheer on 9/20/2016.
 */
public class TheWaitingStatus implements Question<Boolean> {

    private BookingResponse bookingResponse = new BookingResponse();
    private Pet pet;

    public TheWaitingStatus(Pet pet) {
        this.pet = pet;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return bookingResponse.isConfirmed();
    }

    public static TheWaitingStatusBuilder of(Pet pet) {
        return new TheWaitingStatusBuilder(pet);
    }

    public static class TheWaitingStatusBuilder {
        private Pet pet;

        public TheWaitingStatusBuilder(Pet pet) {
            this.pet = pet;
        }

        public Question<Boolean> isConfirmed() {
            return new TheWaitingStatus(pet);
        }
    }
}
