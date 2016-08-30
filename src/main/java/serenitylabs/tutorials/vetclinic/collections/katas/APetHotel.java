package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

/**
 * A utility class to generate pet hotels with pets already booked
 */
public class APetHotel {

    private final String name;
    private final int maximumCapacity;
    private Set<Pet> pets = new TreeSet<>(comparing(Pet::getName));

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


    public BookingResponse checkIn(Pet... somePet) {
        boolean bookingResponse;
        bookingResponse = ((somePet.length <= maximumCapacity) && (pets.size() <= maximumCapacity) && (pets.addAll(Arrays.asList(somePet)))) ? true : false;
        return new BookingResponse(bookingResponse);
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
