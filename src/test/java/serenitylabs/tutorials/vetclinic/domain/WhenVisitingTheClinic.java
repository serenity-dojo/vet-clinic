package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class WhenVisitingTheClinic {
@Test
public void cats_and_Dogs_complain_to_the_assistant()
{
	Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
	Cat felix = Cat.called("Felix").ofBreed("Burmese").andOfColour("Brown");
ComplaintRegister complaintregister=new ComplaintRegister();
VetAssistant assistant=new VetAssistant(complaintregister);
assistant.recordComlainFrom(fido);
//assistant.recordComlainFrom(felix);
assertThat(complaintregister.getComplaints(), hasItems("Grrrr"));

}

@Test	
public void the_vet_should_know_when_a_pet_vaccination_is_due()
{
	Cat felix = Cat.called("Felix").ofBreed("Burmese").andOfColour("Brown");
	LocalDate today= LocalDate.now();
	LocalDate nextYear=today.plusYears(1);
	felix.wasVaccinatedOn(today);
	assertThat(felix.nextVaccinationDue(),is(equalTo(nextYear)));

}

@Test
public void dogs_need_vaccinations_every_six_month()
{
	NeedVaccinations fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
	LocalDate today= LocalDate.now();
	LocalDate inSixMonthTime=today.plusMonths(6);
	fido.wasVaccinatedOn(today);
	assertThat(fido.nextVaccinationDue(),is(equalTo(inSixMonthTime)));

} 


}
