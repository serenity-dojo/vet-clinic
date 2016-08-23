package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import static serenitylabs.tutorials.vetclinic.screenplay.tasks.APetHotel.somePet;

public class FillTheHotel implements Task {
    private final int numberOfPets;

    public FillTheHotel(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    @Step("{0} books in #numberOfPets pets")
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int petcount = 1; petcount <= numberOfPets; petcount++) {
            actor.usingAbilityTo(ManageTheHotel.class).bookPet(somePet(petcount));
        }
    }

    public static FillHotelBuilder with(int numberOfPets) {
        return new FillHotelBuilder(numberOfPets);
    }

    public static class FillHotelBuilder {
        private final int numberOfPets;

        public FillHotelBuilder(int numberOfPets) {
            this.numberOfPets = numberOfPets;
        }

        public Task pets() {
            return new FillTheHotel(numberOfPets);
        }
    }
}
