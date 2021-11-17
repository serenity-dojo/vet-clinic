package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface NeedsVaccinations {
    void wasVaccinatedOn(LocalDate lastVaccinationDate);

    LocalDate nextVaccinationDue();
}
