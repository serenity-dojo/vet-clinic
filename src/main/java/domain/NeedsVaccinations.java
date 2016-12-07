package domain;

import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public interface NeedsVaccinations {
    void wasVaccinatedOn(LocalDate vaccinationDate);

    LocalDate nextVaccinationDate();
}
