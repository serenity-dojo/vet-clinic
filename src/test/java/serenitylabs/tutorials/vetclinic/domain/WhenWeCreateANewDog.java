package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDateTime;

public class WhenWeCreateANewDog {

    private static final LocalDateTime THE_FOURTH_OF_JULY = LocalDateTime.now();

    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDateTime dateOfBirth = LocalDateTime.now();

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .bornOn(dateOfBirth);

    }
}
