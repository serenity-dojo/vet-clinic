package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

public class TripPlannerForm {

    public static final By TRAVEL_DAY = By.cssSelector("#itdDate");
    public static final By TIME_HOUR = By.cssSelector("#itdTimeHour");
    public static final By TIME_MINUTE = By.cssSelector("#itdTimeMinute");
    public static final By DESTINATION = By.id("display_destination");
    public static final By DEPARTURE = By.id("display_origin");

    static final Map<DeparturePreference, By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();
    static {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore, By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter, By.id("itdTripDateTimeDep"));
    }

    public static final By SUBMIT_BUTTON = By.name("btnTripPlannerSubmit");

    public static By departureButtonFor(DeparturePreference departurePreference) {
        return DEPARTURE_RADIO_BUTTONS.get(departurePreference);
    }
}
