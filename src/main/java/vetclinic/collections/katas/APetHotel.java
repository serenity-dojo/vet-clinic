package vetclinic.collections.katas;

import com.google.common.collect.ImmutableList;
import vetclinic.Breed;
import vetclinic.Pet;

import java.util.*;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {
    private final String name;
    private final int count;
    private Collection<Pet> pets = new TreeSet<>(Comparator.comparing(Pet::getName));

    public APetHotel(String hotelName, int petCount) {
        this.name=hotelName;
        this.count=petCount;
    }

    public static PetHotelBuilder with(int petCount) {
        return new PetHotelBuilder(petCount);
    }

    public Collection<Pet> getPets() {
        return pets;
    }

    public void checkIn(Pet pet) {
        pets.add(pet);
    }

    public static class PetHotelBuilder {
        private final int petCount;

        public PetHotelBuilder(int petCount) {
            this.petCount=petCount;
        }

        public APetHotel named(String hotelName) {
            return new APetHotel(hotelName,petCount);
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
