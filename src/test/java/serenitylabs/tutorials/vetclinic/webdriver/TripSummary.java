package serenitylabs.tutorials.vetclinic.webdriver;

import java.util.Objects;

/**
 * Created by siddharthk on 9/18/2016.
 */
public class TripSummary {
    private final String destination;
    private final String arrivalHour;
    private final String arrivalMinute;
    private final String arrivalDay;
    private String arriveOrDepart;
    private String fromStation;

    public TripSummary(String arriveOrDepart, String fromStation, String destination, String arrivalHour, String arrivalMinute, String arrivalDay) {

        this.arriveOrDepart = arriveOrDepart;
        this.fromStation = fromStation;
        this.destination = destination;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.arrivalDay = arrivalDay;
    }

    public static TripSummaryBuilder from(String fromStation) {

        return new TripSummaryBuilder(fromStation);
    }

    public static class TripSummaryBuilder {

        private String destination;
        private String arriveOrDepart;
        private String arrivalHour;
        private String arrivalMinute;
        private String arrivalDay;
        private String fromStation;

        public TripSummaryBuilder(String fromStation) {

            this.fromStation = fromStation;
        }

        public TripSummaryBuilder to(String destination) {

            this.destination = destination;
            return this;
        }

        public TripSummaryBuilder arrivingBeforeOrLeaveAfter(String arriveOrDepart, String arrivalHour, String arrivalMinute) {

            this.arriveOrDepart = arriveOrDepart;
            this.arrivalHour = arrivalHour;
            this.arrivalMinute = arrivalMinute;
            return this;
        }

        public TripSummary on(String arrivalDay) {
            this.arrivalDay = arrivalDay;
            return new TripSummary(arriveOrDepart,fromStation, destination,
                                   arrivalHour, arrivalMinute, arrivalDay);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripSummary that = (TripSummary) o;

        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (arrivalHour != null ? !arrivalHour.equals(that.arrivalHour) : that.arrivalHour != null) return false;
        if (arrivalMinute != null ? !arrivalMinute.equals(that.arrivalMinute) : that.arrivalMinute != null)
            return false;
        if (arrivalDay != null ? !trimDay(arrivalDay).equals(trimDay(that.arrivalDay)) : that.arrivalDay != null) return false;
        if (arriveOrDepart != null ? !arriveOrDepart.equals(that.arriveOrDepart) : that.arriveOrDepart != null)
            return false;
        return fromStation != null ? fromStation.equals(that.fromStation) : that.fromStation == null;

    }

    private String trimDay(String arrivalDay) {

        return arrivalDay.split("\\(")[0].trim();
    }

    @Override
    public int hashCode() {
        int result = destination != null ? destination.hashCode() : 0;
        result = 31 * result + (arrivalHour != null ? arrivalHour.hashCode() : 0);
        result = 31 * result + (arrivalMinute != null ? arrivalMinute.hashCode() : 0);
        result = 31 * result + (arrivalDay != null ? arrivalDay.hashCode() : 0);
        result = 31 * result + (arriveOrDepart != null ? arriveOrDepart.hashCode() : 0);
        result = 31 * result + (fromStation != null ? fromStation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripSummary{" +
                "destination='" + destination + '\'' +
                ", arrivalHour='" + arrivalHour + '\'' +
                ", arrivalMinute='" + arrivalMinute + '\'' +
                ", arrivalDay='" + arrivalDay + '\'' +
                ", arriveOrDepart='" + arriveOrDepart + '\'' +
                ", fromStation='" + fromStation + '\'' +
                '}';
    }
}
