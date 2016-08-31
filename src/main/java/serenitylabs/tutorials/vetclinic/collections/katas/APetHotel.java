package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {

    private final String name;
    private final int maximumCapacity;
    private Set<Pet> pets = new TreeSet<>(comparing(Pet::getName));
    private Queue<Pet> waitingPets = new LinkedList<>();

    public String getName() {
        return name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public APetHotel(AHotelBuilder aHotelBuilder) {
        this.name = aHotelBuilder.name;
        this.maximumCapacity = aHotelBuilder.maximumCapacity;
    }


    public APetHotel(Set<Pet> petsAdded, String name, int maximumCapacity) {
        this.name = name;
        this.maximumCapacity = maximumCapacity;
        pets.addAll(petsAdded);
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);
        if (!waitingPets.isEmpty()) {
            checkIn(waitingPets.poll());
        }
    }


    private enum HotelAvailability { Available, Full}

    private static final Map<HotelAvailability, BookingStrategy> BOOKING_STRATEGY = new HashMap<>();
    {
        BOOKING_STRATEGY.put(HotelAvailability.Available, new ConfirmBookingStrategy(pets));
        BOOKING_STRATEGY.put(HotelAvailability.Full, new WaitingListStrategy(waitingPets));
    }

    private HotelAvailability currentAvailability() {
        return ((pets.size() < maximumCapacity))  ? HotelAvailability.Available : HotelAvailability.Full;
    }

    public BookingResponse checkIn(Pet somePet) {
        BookingStrategy bookingStrategy = BOOKING_STRATEGY.get(currentAvailability());
        return bookingStrategy.checkIn(somePet);
    }


    public  Collection<Pet> getWaitingList() {
        return new LinkedList(waitingPets);
    }


    public static class AHotelBuilder {

        private String name;
        private int maximumCapacity;


        public AHotelBuilder capacity(int maximumCapacity) {
            this.maximumCapacity = maximumCapacity;
            return this;
        }

        public AHotelBuilder named(String name) {
            this.name = name;
            return this;
        }

        public APetHotel build() {
            return new APetHotel(this);
        }


    }
}
