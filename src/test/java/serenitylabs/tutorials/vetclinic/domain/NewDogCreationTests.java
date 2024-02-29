package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDate;
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
    DogEntityImmutableType dogObj=DogEntityImmutableType.getImmutableInstance()
    		                  .called("Fido")
		                      .ofBreed("Labrador")
		                      .bornOn(THE_FOURTH_OF_JULY);
    
    Assert.assertEquals("Fido",dogObj.getDogName());
    Assert.assertEquals("Labrador",dogObj.getDogBreed());
    Assert.assertEquals(THE_FOURTH_OF_JULY,dogObj.getBirthDate());
    System.out.println("\nThis is 4th Test methode.");
	}
	
	
	
	/*
	 * This TestNg test is representing test validation for colour should be a
	 * mandatory field, and optional fields for Favourite Food with builder pattern
	 * implementation.
	 * 
	 * see : Exercises-2 Step 5
	 * 
	 */
	@Test
	public void a_dog_can_have_an_optional_favourite_food() {
	DogEntity dogObj = DogEntity.called("Fido") // mandatory
				                 .ofDogBreed("Labrador") // mandatory
				                 .ofDogColour("black")  //ofColour is mandatory.
				                 .setOptFldFavouriteFood("Pizza") //setOptFldFavouriteFood is optional
				                 .dgEntityBornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Fido", dogObj.getDogName());
		Assert.assertEquals("Labrador", dogObj.getDogBreed());
		Assert.assertEquals("black", dogObj.getFavouriteColour());
		Assert.assertEquals("Pizza", dogObj.getOptFldFavouriteFood());
		Assert.assertEquals(THE_FOURTH_OF_JULY, dogObj.getBirthDateTime());
		System.out.println("\nThis is 6th Test methode.");
	}
	
	
	
	/*
	 * This TestNg test is representing test validation for colour should be a
	 * mandatory field, and optional fields for Favourite Toy with builder pattern
	 * implementation.
	 * 
	 * see : Exercises-2 Step 5
	 * 
	 */
	@Test
	public void a_dog_can_have_an_optional_favourite_toy() {
		DogEntity dogObj=DogEntity.called("Fido") // mandatory
				                  .ofDogBreed("Labrador") // mandatory
				                  .ofDogColour("black")  //ofColour is mandatory.
				                  .setOptFldFavouriteToy("PingPong") // setOptFldFavouriteToy optional
				                  .dgEntityBornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Fido", dogObj.getDogName());
		Assert.assertEquals("Labrador", dogObj.getDogBreed());
		Assert.assertEquals("black", dogObj.getFavouriteColour());
		Assert.assertEquals("PingPong", dogObj.getOptFldFavouriteToy());
		Assert.assertEquals(THE_FOURTH_OF_JULY, dogObj.getBirthDateTime());
		System.out.println("\nThis is 7th Test methode.");
	}
	
	
	
	/*
	 * This TestNg test is implementation for external entity builder class w.r.t
	 * builder prototype method for aLargeDog
	 * 
	 * see : Exercises-3
	 * 
	 */
	@Test
	public void a_aLargeDog_can_have_an_optional_favourite_toy() {
		DogEntityImmutableType dogObj=DogEntityImmutableType.aLargeDog()
				                                            .called("Fido") // mandatory
				                                            .ofColour("black")  //ofColour is mandatory.
				                                            .setOptFldFavouriteToy("PingPong") // setOptFldFavouriteToy optional
				                                            .bornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Fido", dogObj.getDogName());
		Assert.assertEquals("Labrador", dogObj.getDogBreed());
		Assert.assertEquals("black", dogObj.getFavouriteColor());
		Assert.assertEquals("PingPong", dogObj.getOptFldFavouriteToy());
		Assert.assertEquals(THE_FOURTH_OF_JULY, dogObj.getBirthDate());
		System.out.println("\nThis is 8th Test methode with prototype method aLargeDog().");
	}
	
	
	/*
	 * This TestNg test is implementation for external entity builder class w.r.t
	 * builder prototype method for aSmallDog
	 * 
	 * see : Exercises-3
	 * 
	 */
	@Test
	public void a_aSmallDog_can_have_an_optional_favourite_food() {
		DogEntityImmutableType dogObj = DogEntityImmutableType.aSmallDog()
				.called("Spot") // mandatory
			    .ofColour("white") // ofColour is mandatory.
				.setOptFldFavouriteFood("Pizza") // setOptFldFavouriteFood is optional
				.bornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Spot", dogObj.getDogName());
		Assert.assertEquals("Lasa", dogObj.getDogBreed());
		Assert.assertEquals("white", dogObj.getFavouriteColor());
		Assert.assertEquals("Pizza", dogObj.getOptFldFavouriteFood());
		Assert.assertEquals(THE_FOURTH_OF_JULY, dogObj.getBirthDate());
		System.out.println("\nThis is 9th Test methode with prototype method aSmallDog().");
	}
	
	
	
	/*
	 * This TestNg test is implementation for external entity builder class w.r.t
	 * builder prototype method for aGuardDog
	 * 
	 * see : Exercises-3
	 * 
	 */
	@Test
	public void a_aGuardDog_can_have_an_optional_favourite_food() {
		DogEntityImmutableType dogObj = DogEntityImmutableType.aGuardDog()
				.called("Jimmy") // mandatory
				.ofColour("browny-blackish") // ofColour is mandatory.
				.setOptFldFavouriteFood("hot dog") // setOptFldFavouriteFood is optional
				.bornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Jimmy", dogObj.getDogName());
		Assert.assertEquals("German Shepherd", dogObj.getDogBreed());
		Assert.assertEquals("browny-blackish", dogObj.getFavouriteColor());
		Assert.assertEquals("hot dog", dogObj.getOptFldFavouriteFood());
		Assert.assertEquals(THE_FOURTH_OF_JULY, dogObj.getBirthDate());
		System.out.println("\nThis is 10th Test methode with prototype method aGuardDog().");
	}
	
	
	
	/*
	 * This TestNg test is representing test validation for mandatory & optional
	 * field/data member implementation with builder pattern implementation.
	 * 
	 * see : Exercises-2 Step 4 - Colour is an optional field.Use an interface
	 * called WithIBreedable to allow the builder to cater for the mandatory fields
	 * (name, breed and date of birth) and the optional one (colour).
	 * 
	 * This will be deleted once Exercises-2 'Step 5' will be implemented. 
	 * 
	 */
	@Test
	public void a_dog_can_have_an_optional_colour() {
		DogEntity dogObj = DogEntity.called("Fido") // mandatory
				                    .ofDogBreed("Labrador") // mandatory
				                    .ofDogColour("black")  //ofColour is optional.
				                    .dgEntityBornOn(THE_FOURTH_OF_JULY); // mandatory

		Assert.assertEquals("Fido", dogObj.getDogName());
		Assert.assertEquals("Labrador", dogObj.getDogBreed());
		Assert.assertEquals("black", dogObj.getFavouriteColour());
		System.out.println("\nThis is 5th Test methode.");
	}
	
	
	@Test
	public void isNameOfDogExits()
	{
		DogEntity dogObj=new DogEntity();
		dogObj.setDogName("Touchi");
		dogObj.setDogBreed("Lasa");
		LocalDate locDateTimeObj=LocalDate.now();
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
		DogEntityImmutableType dogObj=new DogEntityImmutableType("Touchi","Lasa",locDateTimeObj,"Rasgulla",null,null);
		
		Assert.assertEquals("Touchi",dogObj.getDogName());
		Assert.assertEquals("Rasgulla",dogObj.getFavouriteColor());
		System.out.println("\nThis is 3rd Test methode.");
	}


	
	
}