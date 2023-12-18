package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

        assertThat(appointment.getPetName(), equalTo("Fido"));
        assertThat(appointment.getOwner(), equalTo("Fred"));
        assertThat(appointment.getAppointmentTime(), equalTo(TODAY_AT_2_PM));
    }

    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment
                .forPetCalled("Fido")
                .ownedBy("Fred")
                .because("He is sick")
                .at(TODAY_AT_2_PM);

        assertThat(appointment.getReason().isPresent(), equalTo(true));
        assertThat(appointment.getReason().get(), equalTo("He is sick"));
    }

    /* Step 6 - comparing appointments
    Add methods isBefore(LocalDateTime) and isAfter(LocalDateTime) to the Appointment class.
    Use tests that use Hamcrest matchers to demonstrate that these methods work for a number of cases
    */
    @Test
    public void an_appointment_before_now() {
        LocalDateTime currentDate = LocalDateTime.now();
        Appointment appointmentForPast = new Appointment("Jerry", "Kasia", currentDate.minusDays(1));
        Appointment appointmentForFuture = new Appointment("Tom", "Terry", currentDate.plusDays(1));

        assertThat("Past appointment should be before now", appointmentForPast.isBefore(currentDate),
                                                                    is(true));
        assertThat("Future appointment cannot be before now", appointmentForFuture.isBefore(currentDate),
                                                                    is(false));
    }

    @Test
    public void an_appointment_after_now() {
        LocalDateTime currentDate = LocalDateTime.now();
        Appointment appointmentForPast = new Appointment("Jerry", "Kasia", currentDate.minusDays(1));
        Appointment appointmentForFuture = new Appointment("Tom", "Terry", currentDate.plusDays(1));

        assertThat("Past appointment should not be after now", appointmentForPast.isAfter(currentDate), is(false));
        assertThat("Future appointment should be after now", appointmentForFuture.isAfter(currentDate), is(true));

    }
}
