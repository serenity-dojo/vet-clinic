package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class WhenCollectingAnimals {

    @Test
    public void aListOfAnimalsShouldContainCatsAndDogs(){
        Dog fido = Dog.called("Fido").ofBreed("Poodle").andOfColour("White");
        Cat tom = Cat.called("Tom").ofBreed("Siamese").andOfColour("Gray");

        List<Animal> animalList = new ArrayList<>();
        animalList.add(fido);
        animalList.add(tom);

        assertThat(animalList, hasItems(fido, tom));
    }

    @Test
    public void aDogComplaintsByGrowling() {
        Dog fido = Dog.called("Fido").ofBreed("Poodle").andOfColour("White");

        assertThat(fido.complaint(), is("Grrrr"));
    }

    @Test
    public void aCatComplaintsByMeowing(){
        Cat tom = Cat.called("Tom").ofBreed("Siamese").andOfColour("Gray");

        assertThat(tom.complaint(), is("Meow"));


    }
}
