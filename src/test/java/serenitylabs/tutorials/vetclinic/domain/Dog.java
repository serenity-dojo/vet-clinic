package serenitylabs.tutorials.vetclinic.domain;

public class Dog {
private final String name;
private final String breed;
private final String color;



public String getBreed() {
	return breed;
}

public String getColor() {
	return color;
}

public Dog(String name, String breed, String color) {
	super();
	this.name = name;
	this.breed = breed;
	this.color = color;
}

public String getName() {
	return name;
}



public static DogBuilder called(String name) {
	// TODO Auto-generated method stub
	
	return new DogBuilder(name);
}

public static class DogBuilder{
	private final String name;
	private String breed;
	
	public DogBuilder(String name)
	{
		this.name=name;
	}
	public DogBuilder ofBreed(String breed) {
		// TODO Auto-generated method stub
		this.breed=breed;
		return this;
	}
	public Dog andOfColour(String colour) {
		
		return new Dog(name,breed,colour);
	}
	
}

}
