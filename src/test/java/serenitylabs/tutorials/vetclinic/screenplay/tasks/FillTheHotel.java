package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Breed;
import serenitylabs.tutorials.vetclinic.model.Pet;

public class FillTheHotel implements Task {
    private final int numberOfPets;
    private final Breed breed;

    public FillTheHotel(int numberOfPets, Breed breed) {
        this.numberOfPets = numberOfPets;
        this.breed = breed;
    }

    @Step("{0} books in #numberOfPets pets")
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int petcount = 1; petcount <= numberOfPets; petcount++) {
            Pet pet = new Pet("Pet #" + petcount, breed);
            // TODO: Register the pet with the hotel
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

        public Task cats() {
            return new FillTheHotel(numberOfPets, Breed.Cat);
        }
        public Task dogs() {
            return new FillTheHotel(numberOfPets, Breed.Dog);
        }
    }
}
