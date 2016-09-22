package serenitylabs.tutorials.vetclinic.collections.katas;

import serenitylabs.tutorials.vetclinic.Pet;

import javax.management.QueryEval;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by siddharthk on 9/22/2016.
 */
public class WaitingListStrategy implements CheckInStrategy {
    private Queue<Pet> petsOnWaitingList;

    public WaitingListStrategy(Queue<Pet> petsOnWaitingList) {
        this.petsOnWaitingList = petsOnWaitingList;
    }

    @Override
    public BookingResponse checkIn(Pet pet) {
        petsOnWaitingList.add(pet);
        return  BookingResponse.onWaitingList(pet);
    }
}
