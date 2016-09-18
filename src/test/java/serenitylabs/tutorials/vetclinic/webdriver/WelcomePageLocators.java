package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;

/**
 * Created by siddharthk on 9/18/2016.
 */
public class WelcomePageLocators {

    public static final By HOURS = By.cssSelector("#itdTimeHour");
    public static final By TRAVEL_DATE = By.cssSelector("#itdDate");
    public static final By ARRIVE_BEFORE = By.cssSelector("#itdTripDateTimeArr");
    public static final By LEAVE_AFTER = By.id("itdTripDateTimeDep");
    public static final By VIEW_TRIP = By.name("btnTripPlannerSubmit");
    public static By FROM_STATION = By.id("display_origin");
    public static By DESTINATION_STATION  = By.id("display_destination");
    public static By MINUTES = By.cssSelector("#itdTimeMinute");
}
