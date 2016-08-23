package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.WaitingList;

import java.util.List;

public class ManageTheWaitingList implements AbilityToListPets {
    private final WaitingList waitingList;

    public ManageTheWaitingList(WaitingList waitingList) {
        this.waitingList = waitingList;
    }

    public List<Pet> getPets() {
        return waitingList.getPets();
    }
}
