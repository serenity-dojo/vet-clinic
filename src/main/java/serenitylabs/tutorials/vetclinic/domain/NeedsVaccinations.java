package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public interface NeedsVaccinations {
    void wasVaccinated(LocalDateTime vaccinationDate);
    LocalDateTime nextVaccinationDue();
}
