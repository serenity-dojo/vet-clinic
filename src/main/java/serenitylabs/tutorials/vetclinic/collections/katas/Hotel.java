package serenitylabs.tutorials.vetclinic.collections.katas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import serenitylabs.tutorials.vetclinic.Pet;

public class Hotel {

	private final int MAX_LIMIT = 5;
	Set<Pet> pets = new TreeSet<>();
	Queue<Pet> petsInWaiting = new LinkedList<>();

	public List<Pet> getPets() {
		return new ArrayList<>(pets);
	}
}
