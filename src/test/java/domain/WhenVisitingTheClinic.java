package domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

/**
 * Created by pravyada on 9/12/2016.
 */
public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complaint_to_the_assistant(){
        Dog fido = Dog.called("Fido").ofBreed("Laborador").ofColor("Black");
        Cat felilx = Cat.called("Felix").ofBreed("Siemense").ofColor("White");

        ComplaintRegister complaintRegister = new ComplaintRegister();

        VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        vetAssistant.recordComplainFrom(felilx);
        vetAssistant.recordComplainFrom(fido);

        assertThat(complaintRegister.getComplains(),hasItems("Grrrr","Meow"));
    }

    @Test
    public void the_vet_should_know_when_a_pet_vaccination_is_due(){
        Cat felilx = Cat.called("Felix").ofBreed("Siemense").ofColor("White");

        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);
        felilx.wasVaccinatedOn(today);
        assertThat(felilx.nextVaccinationDate(),is(equalTo(nextYear)));

    }

    @Test
    public void a_dog_should_be_vaccinated_every_six_months(){
        Dog fido = Dog.called("Fido").ofBreed("Laborador").ofColor("Black");

        LocalDate today = LocalDate.now();
        LocalDate nextVaccinationDate = today.plusMonths(6);
        fido.wasVaccinatedOn(today);
        assertThat(fido.nextVaccinationDate(),is(equalTo(nextVaccinationDate)));

    }
}
