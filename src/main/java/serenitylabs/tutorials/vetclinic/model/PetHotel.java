package serenitylabs.tutorials.vetclinic.model;

import com.google.common.collect.ImmutableMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PetHotel {

    public static final int MAXIMUM_PETS = 20;

    private final String hotelName;
    private final GuestList guestList;
    private final WaitingList waitingList;

    public PetHotel(String hotelName,
                    GuestList guestList,
                    WaitingList waitingList) {
        this.hotelName = hotelName;
        this.guestList = guestList;
        this.waitingList = waitingList;
    }

    public PetHotel(String name) {
        this(name, new GuestList(), new WaitingList());
    }

    public List<Pet> getPets() {
        return guestList.getGuests();
    }

    public static PetHotel called(String name) {
        return new PetHotel(name);
    }

    private enum HotelAvailability { Available, Full}

    private Map<HotelAvailability, CheckInStrategy> checkInStrategy() {
        return ImmutableMap.of(
                HotelAvailability.Available, new ConfirmBookingStrategy(guestList),
                HotelAvailability.Full, new WaitingListStrategy(waitingList));
    }

    private HotelAvailability currentAvailability() {
        return (guestList.size() >= MAXIMUM_PETS) ? HotelAvailability.Full : HotelAvailability.Available;
    }

    public BookingResponse checkIn(Pet pet) {
        CheckInStrategy checkInStrategy = checkInStrategy().get(currentAvailability());
        return checkInStrategy.attemptToCheckIn(pet);
    }

    public Collection<Pet> getWaitingList() {
        return waitingList.getPets();
    }

    public void checkOut(Pet pet) {
        guestList.remove(pet);

        if (!waitingList.isEmpty()) {
            checkIn(waitingList.nextInLine());
        }
    }

}
