package serenitylabs.tutorials.vetclinic.domain;

import junit.framework.Assert;

import org.junit.Test;

public class WhenWeCreateANewDog {

	@Test
	public void a_new_dog_should_have_a_name() throws Exception{
		Dog fido= Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
		//fido.setName("Fido");
		Assert.assertEquals("Fido", fido.getName());
		Assert.assertEquals("Labrador", fido.getBreed());
		Assert.assertEquals("Black", fido.getColor());
		
	}
	
}
