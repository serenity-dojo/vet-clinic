package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface NeedVaccinations {
	public void wasVaccinatedOn(LocalDate vaccinationDate);
	public LocalDate nextVaccinationDue();
}
