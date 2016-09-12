package domain;

import org.junit.Test;

import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


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

	@Test
	public void a_dog_complains_by_grawling(){
		Dog fido = Dog.called("Fido").ofBreed("LabroDog").ofColor("black");
		assertThat(fido.complains(),is(equalTo("Grrrr")));
	}

	@Test
	public void a_cat_complains_by_meowing(){
		Cat felix = Cat.called("Felix").ofBreed("Siemense").ofColor("While");
		assertThat(felix.complains(),is(equalTo("Mewo")));
	}
}
