package serenitylabs.tutorials.vetclinic.domain;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.time.LocalDateTime;
import org.testng.annotations.Test;

public class WhenWeBookAnAppointmentTests {

	private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);
	
	/*
	 * This TestNg test is representing test validation for 'Vet Clinic Tutorial 2 -
	 * Hamcrest Matchers' modules Exercise - 'Step 5 - Updating the
	 * WhenWeBookAnAppointmentTests test' implementation
	 * 
	 */
	@Test
	public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
		AppointmentEntity appointObj = AppointmentEntity.forPetCalled("Fido")
				                            .ownedBy("Fred")
				                            .at(TODAY_AT_2_PM);

		assertThat(appointObj.getPetName(),is(equalTo("Fido")));
		assertThat(appointObj.getOwner(),is(equalTo("Fred")));
		assertThat(appointObj.getAppointmentTime(),is(equalTo(TODAY_AT_2_PM)));
		System.out.println("Execution of - 'Step 5 - Updating the WhenWeBookAnAppointment tests' completed.");
	}

	
	/*
	 * This TestNg test is representing test validation for 'Vet Clinic Tutorial 2 -
	 * Hamcrest Matchers' modules Exercise - 'Step 6 - comparing appointments'
	 * implementation
	 * 
	 */
	@Test
	public void an_appointment_can_have_an_optional_reason() {
		AppointmentEntity appointObj = AppointmentEntity.forPetCalled("Fido")
				                            .ownedBy("Fred")
				                            .because("He is sick")
				                            .at(TODAY_AT_2_PM);

		assertThat(appointObj.getReason().isPresent(),is(true));
		assertThat(appointObj.getReason().get(),is(equalTo("He is sick")));
		System.out.println("Execution of - 'Step 6 - comparing appointments' tests completed.");
	}


}