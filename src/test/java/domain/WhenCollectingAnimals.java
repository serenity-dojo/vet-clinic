package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

/**
 * Created by pravyada on 9/12/2016.
 */
public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_have_dogs_and_cats(){
        Dog fido = Dog.called("Fido").ofBreed("Laborador").ofColor("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siemense").ofColor("White");

        List<Animal> animalList = new ArrayList<Animal>();

        animalList.add(fido);
        animalList.add(felix);

        assertThat(animalList,hasItems(fido,felix));

    }
}
