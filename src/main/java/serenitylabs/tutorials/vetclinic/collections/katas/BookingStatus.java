package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by sapurani on 8/31/2016.
 */
public enum BookingStatus implements BookingStrategy {

    AVAILABLE{
        @Override
        public BookingResponse checkIn(Pet... pet){
            return new BookingResponse(true);
        }
    },

    FULL{
        @Override
        public BookingResponse checkIn(Pet... pet){
            return new BookingResponse(false);
        }
    };

    public abstract  BookingResponse checkIn(Pet... pet);
}
