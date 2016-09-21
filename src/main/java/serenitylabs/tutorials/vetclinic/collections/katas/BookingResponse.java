package serenitylabs.tutorials.vetclinic.collections.katas;


import serenitylabs.tutorials.vetclinic.Pet;

/**
 * Created by aatchoud on 9/20/2016.
 */
public class BookingResponse {
    private static boolean isConfirm = false;

    public BookingResponse(boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Boolean isConfirmed(){
        return isConfirm;
        }

}



