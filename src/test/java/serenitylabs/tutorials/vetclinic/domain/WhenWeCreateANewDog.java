package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhenWeCreateANewDog {

	@Test
	public void a_new_dog_should_have_a_name() throws Exception {
		Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
		assertThat(fido.getBreed(), equalTo("Labrador"));
		assertThat(fido.getName(), equalTo("Fido"));
		assertThat(fido.getColor(), contains("Black"));

	}

	@Test
	public void a_dog_can_have_several_colours() {
		Dog fido = Dog.called("Fido").ofBreed("Labrador")
				.andOfColour("Black", "White");
		assertThat(fido.getColor(), contains("Black", "White"));
	}
	
	@Test
	public void a_dog_complains_by_growling(){
		Dog fido = Dog.called("Fido").ofBreed("Labrador")
				.andOfColour("Black", "White");
		
		assertThat(fido.complaint(),is(equalTo("Grrrr")));
	}
	
	@Test
	public void a_Cat_complains_by_meowing(){
		Cat felix = Cat.called("Felix").ofBreed("Burmese")
				.andOfColour("Brown");
		
		assertThat(felix.complaint(),is(equalTo("Meow")));
	}

}
