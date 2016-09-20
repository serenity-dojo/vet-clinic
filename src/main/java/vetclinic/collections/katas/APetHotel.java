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
    private  Queue<Pet> waitingPets = new LinkedList<>();

    public Queue<Pet> getWaitingPets() {
        return waitingPets;
    }

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

    public BookingConfirmation checkIn(Pet pet) {
        BookingStratgey bookingStrategy = BOOKING_STARTEGY.get(currentAvailability());
        return bookingStrategy.checkIn(pet);
    }


    private static final Map<HotelAvailability,BookingStratgey> BOOKING_STARTEGY= new HashMap<>();{
        BOOKING_STARTEGY.put(HotelAvailability.AVAILABLE,new ConfirmBookingStrategy(pets));
        BOOKING_STARTEGY.put(HotelAvailability.FULL,new WaitingStrategy(waitingPets));
    }

    private HotelAvailability currentAvailability() {
        return ((pets.size() < count))  ? HotelAvailability.AVAILABLE : HotelAvailability.FULL;
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);
        if(!waitingPets.isEmpty()){
            pets.add(waitingPets.poll());
        }

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

        public void checkInDefaultPets() {
            somePet(petCount);
    }
        private String someName(int petCount) {
            return PET_NAMES.get(random.nextInt(PET_NAMES.size())) + " " + petCount;
        }
    }
}
