package serenitylabs.tutorials.vetclinic.collections.exercises;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.enumerations.exercises.BreedEnum;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;

public class WhenWorkingWithAPetMapTests {
	
	@Test
	public void pets_can_be_found_by_their_name() {
		Map<String, PetEntity> pets = new HashMap<>();

		PetEntity fido = PetEntity.dog().named("Fido");

		pets.put("Fido", fido);

		// TODO
		assertThat(pets.get("Fido"), equalTo(fido));
	System.out.println("\nStep-1 - TC-01 - Executing pets_can_be_found_by_their_name() ");
	}

	
    @Test
    public void should_be_able_to_get_a_default_value_if_no_matching_key_is_present() {
        Map<String, PetEntity> pets = new HashMap<>();

        PetEntity fido = PetEntity.dog().named("Fido");
        PetEntity stray = PetEntity.dog().named("Stray");

        pets.put("Fido", fido);
        pets.put("Stray", stray);

        PetEntity retrievedPet = pets.getOrDefault("Rover", stray);

        // TODO
        assertThat(retrievedPet, equalTo(stray));
    System.out.println("\nStep-2 - TC-02 - should_be_able_to_get_a_default_value_if_no_matching_key_is_present() ");
    }


    @Test
    public void the_map_keys_should_be_the_pet_names() {
        Map<String, PetEntity> pets = new HashMap<>();

        PetEntity fido = PetEntity.dog().named("Fido");
        PetEntity felix = PetEntity.cat().named("Felix");

        pets.put("Fido", fido);
        pets.put("Felix", felix);

        // TODO
        assertThat(pets.keySet(), containsInAnyOrder("Fido","Felix"));
    System.out.println("\nStep-3 - TC-03 - the_map_keys_should_be_the_pet_names() ");
    }

    
    @Test
    public void the_map_should_store_pets_in_alphabetical_order() {
        // TODO: Instantiate the correct type of Map
        NavigableMap<String, PetEntity> pets = new  TreeMap<>();

        pets.put("Rover", PetEntity.dog().named("Rover"));
        pets.put("Felix", PetEntity.cat().named("Felix"));
        pets.put("Spot", PetEntity.cat().named("Spot"));

        assertThat(pets.keySet(), contains("Felix","Rover","Spot"));
    System.out.println("\nStep-4 - TC-04 - the_map_should_store_pets_in_alphabetical_order() ");
    }

    
    @Test
    public void the_map_should_store_pets_in_the_order_they_where_added() {
        // TODO: Instantiate the correct type of Map
        Map<String, PetEntity> pets =  new LinkedHashMap<>();

        pets.put("Spot", PetEntity.cat().named("Spot"));
        pets.put("Rover", PetEntity.dog().named("Rover"));
        pets.put("Felix", PetEntity.cat().named("Felix"));
        pets.put("Fido", PetEntity.cat().named("Fido"));

        assertThat(pets.keySet(), contains("Spot", "Rover","Felix", "Fido"));
    System.out.println("\nStep-5 - TC-05 - the_map_should_store_pets_in_the_order_they_where_added() ");
    }

    
    @Test
    public void the_map_should_store_pet_leaders_by_breed() {
        // TODO: Create an EnumMap to define a pet leader for each breed
        EnumMap<BreedEnum, PetEntity> petLeaders =  new EnumMap<>(BreedEnum.class);

        petLeaders.put(BreedEnum.Cat, PetEntity.cat().named("Felix"));
        petLeaders.put(BreedEnum.Dog, PetEntity.dog().named("Lassie"));
        petLeaders.put(BreedEnum.Rabbit, PetEntity.cat().named("Hazel"));

        assertThat(petLeaders.get(BreedEnum.Dog).getName(), equalTo("Lassie"));
    System.out.println("\nStep-6 - TC-06 - the_map_should_store_pet_leaders_by_breed() ");
    }

}