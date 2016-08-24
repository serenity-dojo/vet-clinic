package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by siddharthk on 8/23/2016.
 */
public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name(){

        Dog fido = Dog.named("fido").ofBreed("Labarador").ofColor("Red");
        assertThat(fido.getName(), containsString("fido"));
        assertThat(fido.getBreed(),containsString("Labarador"));
        assertThat(fido.getColor(),containsString("Red"));
    }
}
