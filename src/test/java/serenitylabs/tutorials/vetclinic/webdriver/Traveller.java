package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ARRIVE_BEFORE;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LEAVE_AFTER;

/**
 * Created by siddharthk on 9/18/2016.
 */
public class Traveller {
    private WebDriver driver;

    public Traveller(WebDriver driver) {
        this.driver = driver;
    }

    public void planTheTrip() {
        driver.findElement(WelcomePageLocators.VIEW_TRIP).click();
    }

    private static Map<DeparturePreference, By> DEPARTURE_PREFERENCE_SELECTOR = new HashMap<>();
    static {
        DEPARTURE_PREFERENCE_SELECTOR.put(ARRIVE_BEFORE, WelcomePageLocators.ARRIVE_BEFORE);
        DEPARTURE_PREFERENCE_SELECTOR.put(LEAVE_AFTER, WelcomePageLocators.LEAVE_AFTER);
    }

    public void theTrainShould(DeparturePreference departurePreference, String hour, String minutes, Day travelDay) {

        driver.findElement(DEPARTURE_PREFERENCE_SELECTOR.get(departurePreference)).click();

        new Select(driver.findElement(WelcomePageLocators.TRAVEL_DATE)).selectByIndex(travelDay.getDay());

        Select hourSelector = new Select(driver.findElement(WelcomePageLocators.HOURS));
        hourSelector.selectByVisibleText(hour);

        Select minute = new Select(driver.findElement(WelcomePageLocators.MINUTES));
        minute.selectByVisibleText(minutes);
    }

    public void arrivalStationIs(String arrivalStation) {
        driver.findElement(WelcomePageLocators.DESTINATION_STATION).sendKeys(arrivalStation);
    }

    public void departureStationIs(String departureStation) {
        driver.findElement(WelcomePageLocators.FROM_STATION).sendKeys(departureStation);
    }

    public TripSummary getDisplayedTripPreferences() {

        String arriveOrDepart = new Select(driver.findElement(TripPlannerLocators.ARRIVE_OR_DEPART)).getFirstSelectedOption().getText();
        String displayedOrigin = driver.findElement(TripPlannerLocators.FROM_STATION).getAttribute("value");
        String displayedDestination = driver.findElement(TripPlannerLocators.DESTINATION_STATION).getAttribute("value");
        String arrivalDay = new Select(driver.findElement(TripPlannerLocators.ARRIVAL_DATE)).getFirstSelectedOption().getText();
        String arrivalHour = new Select(driver.findElement(TripPlannerLocators.HOUR)).getFirstSelectedOption().getText();
        String arrivalMinute = new Select(driver.findElement(TripPlannerLocators.MINUTES)).getFirstSelectedOption().getText();

        return TripSummary.from(displayedOrigin)
                .to(displayedDestination)
                .arrivingBeforeOrLeaveAfter(arriveOrDepart,arrivalHour,arrivalMinute)
                .on(arrivalDay);
    }
}
