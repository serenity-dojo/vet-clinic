package serenitylabs.tutorials.vetclinic.enumerations.exercises;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class WhenCreatingAComplexEnumTests {

    /**
     * Add the scientific name to the animal breeds.
     * Cat = "Felis catus"
     * Dog = "Canis lupus familiaris"
     * Rabbit = "Oryctolagus cuniculus"
     * Fish = "Carassius auratus"
     * Parrot = "Psittaciformes"
     */
    @Test
    public void should_be_able_to_find_the_scientific_names_of_an_animal_breed() {

        // TODO: Refactor the Breed enum so that it also stores the scientific name (see comment above).
        assertThat(BreedEnum.Cat.getScientificName(), equalTo("Felis catus"));
        assertThat(BreedEnum.Dog.getScientificName(), equalTo("Canis lupus familiaris"));
        assertThat(BreedEnum.Rabbit.getScientificName(), equalTo("Oryctolagus cuniculus"));
        System.out.println("\nThis is - TC-01 - should_be_able_to_find_the_scientific_names_of_an_animal_breed");
    }
    
}