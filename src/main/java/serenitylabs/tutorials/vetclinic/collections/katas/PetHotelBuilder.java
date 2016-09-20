package serenitylabs.tutorials.vetclinic.collections.katas;

/**
 * Created by pawpawar on 9/20/2016.
 */
public class PetHotelBuilder {
    private int petCount;
    private String name;
    private int maximumCapacity;

    public PetHotelBuilder(int petCount) {
        this.petCount = petCount ;
    }

    public static PetHotelBuilder with(int petCount) {

        return new PetHotelBuilder(petCount);
    }

    public PetHotel petsCheckedIn() {
        PetHotel hotel=new PetHotel(name,  maximumCapacity);
        for(int i=0;i<petCount;i++){
            hotel.checkIn(Pet.dog().named("rocky_"+i));
        }
        return hotel;
    }

}
