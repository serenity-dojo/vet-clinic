package serenitylabs.tutorials.vetclinic.screenplay;

public class NotAHotelManagerException extends RuntimeException {
    public NotAHotelManagerException(String name) {
        super(name + " is not a hotel manager");
    }
}
