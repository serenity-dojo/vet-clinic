package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;





import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhenCollectingAnimals {

	@Test
	public void a_list_of_animals_can_contain_cats_and_dogs()
	{
		Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
		Cat felix = Cat.called("Felix").ofBreed("Burmese")
				.andOfColour("Brown");

		List<Animal> animals= new ArrayList<>();
		animals.add(fido);
		animals.add(felix);
		
		assertThat(animals,hasItems(felix,fido));
		
		
	}
}
