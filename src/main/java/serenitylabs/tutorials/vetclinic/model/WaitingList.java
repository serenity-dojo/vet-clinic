package serenitylabs.tutorials.vetclinic.model;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class WaitingList {
    private Queue<Pet> waitingList = new LinkedList<>();

    public void add(Pet pet) {
        waitingList.add(pet);
    }

    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    public Pet nextInLine() {
        return waitingList.poll();
    }

    public Collection<Pet> getPets() {
        return ImmutableList.copyOf(waitingList);
    }
}
