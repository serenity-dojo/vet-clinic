package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Limitations of Default constructor and over come through Builder pattern.
 * 
 */

public class NewDogCreationTests {
	
	private static final LocalDate THE_FOURTH_OF_JULY=LocalDate.of(2024,07,04);
	
	
	/*
	 * This TestNg test is representing test validation with builder pattern
	 * implementation. 
	 * 
	 * see : Exercises-1
	 * Step 1 - Creating a Dog with a name.
	 * Step 2 - Adding a date of birth.
	 * Step 3 - Adding a breed.
	 * 
	 */
	@Test
	public void a_new_dog_should_have_a_name()
	{
    DogEntityImmutableType dogObj=DogEntityImmutableType.called("Fido")
		                          .ofBreed("Labrador")
		                          .bornOn(THE_FOURTH_OF_JULY);
    
    Assert.assertEquals("Fido",dogObj.getDogName());
    Assert.assertEquals("Labrador",dogObj.getDogBreed());
    Assert.assertEquals(THE_FOURTH_OF_JULY,dogObj.getBirthDate());
    System.out.println("\nThis is 4th Test methode.");
	}
	
	
	@Test
	public void isNameOfDogExits()
	{
		DogEntity dogObj=new DogEntity();
		dogObj.setDogName("Touchi");
		dogObj.setDogBreed("Lasa");
		LocalDateTime locDateTimeObj=LocalDateTime.now();
		dogObj.setBirthDateTime(locDateTimeObj);
		
		Assert.assertEquals("Touchi",dogObj.getDogName());
		Assert.assertEquals("Lasa",dogObj.getDogBreed());
		Assert.assertEquals(locDateTimeObj,dogObj.getBirthDateTime());
		System.out.println("\nThis is 1st Test methode.");
	}
	
	
	@Test
	public void isDogsArrtibuteExits()
	{
		LocalDate locDateTimeObj=LocalDate.now();
		DogEntityImmutableType dogObj=new DogEntityImmutableType("Touchi","Lasa",locDateTimeObj);
		
		Assert.assertEquals("Touchi",dogObj.getDogName());
		Assert.assertEquals("Lasa",dogObj.getDogBreed());
		Assert.assertEquals(locDateTimeObj,dogObj.getBirthDate());
		System.out.println("\nThis is 2nd Test methode.");
	}
	
	
	@Test
	public void isOptionalFavouriteFoodFieldExists()
	{
		LocalDate locDateTimeObj=LocalDate.now();
		DogEntityImmutableType dogObj=new DogEntityImmutableType("Touchi","Lasa",locDateTimeObj,"Rasgulla");
		
		Assert.assertEquals("Touchi",dogObj.getDogName());
		Assert.assertEquals("Rasgulla",dogObj.getFavouriteFood());
		System.out.println("\nThis is 3rd Test methode.");
	}

	
}