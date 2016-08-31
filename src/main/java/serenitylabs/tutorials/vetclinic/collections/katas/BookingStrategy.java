package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by sapurani on 8/31/2016.
 */
public interface BookingStrategy {

    public  BookingResponse checkIn( Pet pet);
}
