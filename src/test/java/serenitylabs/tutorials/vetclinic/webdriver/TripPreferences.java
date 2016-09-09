package serenitylabs.tutorials.vetclinic.webdriver;

import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TripPreferences {
    private final String arriveOrDepart;
    private final String displayedOrigin;
    private final String displayedDestination;
    private final String arrivalDay;
    private final String arrivalHour;
    private final String arrivalMinute;

    public TripPreferences(String arriveOrDepart,
                           String displayedOrigin,
                           String displayedDestination,
                           String arrivalDay,
                           String arrivalHour,
                           String arrivalMinute) {

        this.arriveOrDepart = arriveOrDepart;
        this.displayedOrigin = displayedOrigin;
        this.displayedDestination = displayedDestination;
        this.arrivalDay = arrivalDay;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
    }

    public String getArriveOrDepart() {
        return arriveOrDepart;
    }

    public String getDisplayedOrigin() {
        return displayedOrigin;
    }

    public String getDisplayedDestination() {
        return displayedDestination;
    }

    public String getArrivalDay() {
        return arrivalDay;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public String getArrivalMinute() {
        return arrivalMinute;
    }

    public static TripPreferencesBuilder arrivingOrDeparting(String arriveOrDepart) {
        return new TripPreferencesBuilder(arriveOrDepart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripPreferences that = (TripPreferences) o;
        return Objects.equal(arriveOrDepart, that.arriveOrDepart) &&
                Objects.equal(displayedOrigin, that.displayedOrigin) &&
                Objects.equal(displayedDestination, that.displayedDestination) &&
                Objects.equal(shortened(arrivalDay), shortened(that.arrivalDay)) &&
                Objects.equal(arrivalHour, that.arrivalHour) &&
                Objects.equal(arrivalMinute, that.arrivalMinute);
    }

    private String shortened(String arrivalDay) {
        return arrivalDay.split("\\(")[0].trim();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(arriveOrDepart, displayedOrigin, displayedDestination, arrivalDay, arrivalHour, arrivalMinute);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("arriveOrDepart", arriveOrDepart)
                .append("displayedOrigin", displayedOrigin)
                .append("displayedDestination", displayedDestination)
                .append("arrivalDay", arrivalDay)
                .append("arrivalHour", arrivalHour)
                .append("arrivalMinute", arrivalMinute)
                .toString();
    }

    public static class TripPreferencesBuilder {
        private final String arriveOrDepart;
        private String displayedOrigin;
        private String displayedDestination;
        private String arrivalDay;

        public TripPreferencesBuilder(String arriveOrDepart) {

            this.arriveOrDepart = arriveOrDepart;
        }

        public TripPreferencesBuilder from(String displayedOrigin) {
            this.displayedOrigin = displayedOrigin;
            return this;
        }

        public TripPreferencesBuilder to(String displayedDestination) {
            this.displayedDestination = displayedDestination;
            return this;
        }

        public TripPreferencesBuilder arrivingOn(String arrivalDay) {
            this.arrivalDay = arrivalDay;
            return this;
        }

        public TripPreferences at(String arrivalHour, String arrivalMinute) {
            return new TripPreferences(arriveOrDepart,
                    displayedOrigin,
                    displayedDestination,
                    arrivalDay,
                    arrivalHour,
                    arrivalMinute);
        }
    }
}
