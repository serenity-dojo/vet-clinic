package domain;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class WhenCreateANewDog {
	@Test
	public void a_new_dog_should_have_a_name() {
		// Note.... constructor with too many parameters is hard to read
		//Dog fido = new Dog("Fido", "LabroDog", LocalDate.now());
		
		// Using Builder pattern
		Dog fido = Dog.called("Fido").ofBreed("LabroDog").ofColor("black");
		Assert.assertEquals("Fido", fido.getName());
		Assert.assertEquals("LabroDog", fido.getBreed());
		Assert.assertEquals("black", fido.getColor());
	}
}
