package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        List<Animal> animals = new ArrayList<>();

        animals.add(fido);
        animals.add(felix);

        assertThat(animals).containsExactly(fido, felix);
    }

    @Test
    public void a_dog_complains_by_growling() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.complaint()).isEqualTo("Grrrr");
    }

    @Test
    public void a_cat_complains_by_meowing() {
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        assertThat(felix.complaint()).isEqualTo("Meow");
    }
}
