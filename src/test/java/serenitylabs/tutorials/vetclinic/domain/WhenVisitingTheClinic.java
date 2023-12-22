package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.*;

public class WhenVisitingTheClinic {
    @Test
    public void catsAndDogsComplainToTheAssistant() {
        Dog fido = Dog.called("Fido").ofBreed("Bulldog").andOfColour("Brown");
        Cat teddy = Cat.called("Teddy").ofBreed("Siamese").andOfColour("Gray");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        vetAssistant.recordComplainFrom(fido); //the assistant should be able to record complaints from animals
        vetAssistant.recordComplainFrom(teddy);

        Assert.assertThat(complaintRegister.getComplaints(), hasItems("Grrrr", "Meow"));
    }
    @Test
    public void theVetShouldKnowWhenAPetVaccinationIsDue() {
        NeedsVaccinations teddy = Cat.called("Teddy").ofBreed("Siamese").andOfColour("Gray");//Dog class replaced
                                                                    // by NeedsVaccinations because of Interface
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime nextYear = today.plusYears(1);

        teddy.wasVaccinated(today);
        Assert.assertThat(teddy.nextVaccinationDue(), is(equalTo(nextYear)));

    }
    @Test
    public void dogsNeedToBeVaccinatedEverySixMonths() {
        NeedsVaccinations fido = Dog.called("Fido").ofBreed("Bulldog").andOfColour("Brown");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime inSixMonths = today.plusMonths(6);

        fido.wasVaccinated(today);
        Assert.assertThat(fido.nextVaccinationDue(), is(equalTo(inSixMonths)));


    }
}
