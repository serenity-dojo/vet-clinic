package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complain_to_the_assistant() {
        Dog fido = Dog.called("Fido").ofBreed("Laborador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant assistant = new VetAssistant(complaintRegister);

        assistant.recordComplaintrom(fido);
        assistant.recordComplaintrom(felix);

        assertThat(complaintRegister.getCompaints(), hasItems("Grrrr", "Meow"));
    }

    @Test
    public void the_vet_should_know_when_a_pet_vaccination_is_due() {
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        felix.wasVaccinatedOn(today);

        assertThat(felix.nextVaccinationDue(), is(equalTo(nextYear)));
    }

    @Test
    public void dogs_need_vaccinations_every_six_months() {
        Dog fido = Dog.called("Fido").ofBreed("Laborador").andOfColour("Black");

        LocalDate today = LocalDate.now();
        LocalDate inSixMonthsTime = today.plusMonths(6);

        fido.wasVaccinatedOn(today);

        assertThat(fido.nextVaccinationDue(), is(equalTo(inSixMonthsTime)));
    }

}
