package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complain_to_the_assistant() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant assistant = new VetAssistant(complaintRegister);

        assistant.recordComplaintFrom(fido);
        assistant.recordComplaintFrom(felix);

        assertThat(complaintRegister.getComplaints()).containsExactly("Grrrr", "Meow");
    }

    @Test
    public void the_vet_should_know_when_a_pet_vaccination_is_due() {
        NeedsVaccinations felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");

        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        felix.wasVaccinatedOn(today);

        assertThat(felix.nextVaccinationDue()).isEqualTo(nextYear);
    }

    @Test
    public void dogs_need_to_be_vaccinated_every_six_months() {
        NeedsVaccinations fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        LocalDate today = LocalDate.now();
        LocalDate inSixMonthsTime = today.plusMonths(6);

        fido.wasVaccinatedOn(today);

        assertThat(fido.nextVaccinationDue()).isEqualTo(inSixMonthsTime);
    }
}
