package serenitylabs.tutorials.vetclinic.screenplay;

import com.google.common.collect.ImmutableList;
import serenitylabs.tutorials.vetclinic.model.Breed;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.model.WaitingList;

import java.util.List;
import java.util.Random;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {
    public static PetAdder with(int petCount) {
        return new PetAdder(petCount);
    }

    public static class PetAdder {
        private final int petCount;

        public PetAdder(int petCount) {

            this.petCount = petCount;
        }

        public PetHotel petsCheckedIn()  {
            PetHotel hotel = new PetHotel("Pet Hotel", new GuestList(), new WaitingList());
            for(int count = 0; count < petCount; count++) {
                hotel.checkIn(somePet(count));
            }
            return hotel;
        }

        private Pet somePet(int petCount) {
            return new Pet(someName(petCount), someBreed());
        }

        private final static Random random = new Random();

        private Breed someBreed() {
            return Breed.values()[ random.nextInt(Breed.values().length) ];
        }

        private final static List<String> PET_NAMES = ImmutableList.of("Fido","Felix","Rover","Spot");

        private String someName(int petCount) {
            return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
        }
    }
}
