package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Cat extends Animal implements NeedVaccinations{
	private final String name;
	private final String breed;
	private final List<String> colors;
	private LocalDate lastVaccinatedOn;

	public String getBreed() {
		return breed;
	}

	public List<String> getColor() {
		return new ArrayList(colors);
	}

	public Cat(String name, String breed, List<String> colors) {
		super();
		this.name = name;
		this.breed = breed;
		this.colors = colors;
	}

	public String getName() {
		return name;
	}

	public static DogBuilder called(String name) {
		// TODO Auto-generated method stub

		return new DogBuilder(name);
	}

	public static class DogBuilder {
		private final String name;
		private String breed;

		public DogBuilder(String name) {
			this.name = name;
		}

		public DogBuilder ofBreed(String breed) {
			// TODO Auto-generated method stub
			this.breed = breed;
			return this;
		}

		public Cat andOfColour(String... colour) {

			return new Cat(name, breed, ImmutableList.of(colour));
		}

	}

	@Override
	public String complaint() {
		// TODO Auto-generated method stub
		return "Meow";
	}

	public void wasVaccinatedOn(LocalDate vaccinationDate) {
		// TODO Auto-generated method stub
		this.lastVaccinatedOn=vaccinationDate;
		
	}

	public LocalDate nextVaccinationDue() {
		// TODO Auto-generated method stub
		return lastVaccinatedOn.plusYears(1);
	}

	
	
}
