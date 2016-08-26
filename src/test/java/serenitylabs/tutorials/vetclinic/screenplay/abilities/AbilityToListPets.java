package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.Pet;

import java.util.List;

public interface AbilityToListPets extends Ability {
    List<Pet> getPets();
}
