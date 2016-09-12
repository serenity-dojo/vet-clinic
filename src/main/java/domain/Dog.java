package domain;

// Immutable java class without setter methods
// Builder pattern used

import java.time.LocalDate;

/**
 * @author pravyada
 *
 */
public class Dog extends Animal implements NeedsVaccinations {

	private final String name;
	private final String breed;
	private final String color;
	private LocalDate lastVaccinationDate;


	/**
	 * @param name
	 * @param breed
	 * @param color
	 */
	public Dog(String name, String breed, String color) {
		this.name = name;
		this.breed = breed;
		this.color = color;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return String
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	public static DogBuilder called(String name) {
		return new DogBuilder(name);
	}

	@Override
	public String complains() {

		return "Grrrr";
	}

	@Override
	public void wasVaccinatedOn(LocalDate vaccinationDate) {
	this.lastVaccinationDate = vaccinationDate;
	}

	@Override
	public LocalDate nextVaccinationDate() {

		return  lastVaccinationDate.plusMonths(6);
	}

	public static class DogBuilder {
		private final String name;
		private String breed;

		public DogBuilder(String name) {
			this.name = name;
		}

		public DogBuilder ofBreed(String breed) {
			this.breed = breed;
			return this;
		}

		public Dog ofColor(String color) {
			return new Dog(name, breed, color);
		}

	}
}
